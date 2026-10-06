#!/usr/bin/env bash
# Usage: ./scripts/run-cpp.sh <source.cpp> [program arguments...]
# LOCAL enables a guarded local main() in LeetCode solutions.
set -euo pipefail

fail() {
    printf 'Error: %s\n' "$*" >&2
    exit 1
}

if [[ $# -lt 1 ]]; then
    printf 'Usage: %s <source.cpp> [program arguments...]\n' "$0" >&2
    exit 2
fi

repo_root="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")/.." && pwd -P)"
[[ -f "$1" && "$1" == *.cpp ]] || fail "Expected a C++ source file: $1"
source_dir="$(cd -- "$(dirname -- "$1")" && pwd -P)"
source_file="$source_dir/$(basename -- "$1")"
shift
case "$source_file" in
    "$repo_root"/*) ;;
    *) fail 'Source file must be inside the repository.' ;;
esac

compiler="${CXX:-clang++}"
command -v "$compiler" >/dev/null 2>&1 || fail "Compiler not found: $compiler"
relative_file="${source_file#"$repo_root"/}"
executable="$repo_root/build/${relative_file%.cpp}/run"
mkdir -p -- "$(dirname -- "$executable")"

# Status messages go to stderr so stdout can be redirected for comparison.
printf 'Compiling: %s\n' "$relative_file" >&2
"$compiler" -std=c++17 -Wall -Wextra -pedantic -g -DLOCAL "$source_file" -o "$executable"
printf 'Running: %s\n' "$relative_file" >&2
exec "$executable" "$@"
