# Source this file from ~/.zshrc (zsh) or ~/.bashrc (bash).
# Keep the runner path independent of the current working directory.
if [ -n "${ZSH_VERSION:-}" ]; then
    _ps_init_file="${(%):-%x}"
elif [ -n "${BASH_VERSION:-}" ]; then
    _ps_init_file="${BASH_SOURCE[0]}"
else
    printf 'PS shell initialization requires zsh or bash.\n' >&2
    return 1
fi

PS_CPP_RUNNER="$(cd -- "$(dirname -- "$_ps_init_file")" && pwd -P)/run-cpp.sh"
unset _ps_init_file

run() {
    command bash "$PS_CPP_RUNNER" "$@"
}
