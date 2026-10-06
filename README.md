# PS

알고리즘 문제 풀이와 복습을 기록하는 저장소입니다. 현재는 C++17로 LeetCode를 중심으로 풀고, 기존 Java BOJ 풀이는 보관합니다.

## 구조

```text
cpp/
  boj/              # 1931.cpp 등 문제 번호로 관리
  leetcode/         # 1-two-sum.cpp 등 번호와 이름으로 관리
java/
  legacy-boj/       # 기존 Bronze, Silver, Gold Java 풀이
scripts/           # run-cpp.sh, shell-init.sh
.vscode/           # 현재 파일 실행 작업
```

새 언어는 루트에 언어 폴더를 추가하고 그 아래 플랫폼별로 구분합니다. 문제 번호는 원래 번호를 사용하고, 영문 이름은 소문자와 하이픈으로 작성합니다. 알고리즘 태그와 접근, 복잡도, 복습 메모는 각 소스 파일 상단 주석에 기록합니다. 검증 결과는 온라인 제출 통과와 로컬 테스트 통과를 구분합니다.

## C++ 실행

`clang++`와 Bash가 필요합니다. 실행 파일은 Git에서 제외되는 `build/`에 생성됩니다.

짧은 `run` 명령은 셸 초기화 파일을 한 번 불러오면 사용할 수 있습니다.

```sh
source scripts/shell-init.sh
run cpp/boj/1931.cpp < input.txt
run cpp/leetcode/1-two-sum.cpp
```

새 터미널에서도 사용하려면 `~/.zshrc`에 이 저장소의 `scripts/shell-init.sh`를 불러오는 `source` 줄을 추가합니다. 파일 경로는 현재 작업 디렉터리를 기준으로 해석됩니다. 저장소를 이동하면 초기화 경로도 갱신합니다. 소스 경로만 입력하는 대신 `run <파일.cpp>`로 실행합니다.

```sh
./scripts/run-cpp.sh cpp/boj/1931.cpp
# 저장된 입력을 사용할 때
./scripts/run-cpp.sh cpp/boj/1931.cpp < input.txt
```

BOJ 파일에는 표준 입력과 출력을 처리하는 `main()`을 작성합니다. LeetCode는 한 파일에 `Solution`과 `#ifdef LOCAL`로 감싼 테스트용 `main()`을 작성합니다. 스크립트가 `LOCAL`을 정의하여 테스트를 실행합니다. 제출할 때는 `Solution`과 필요한 헤더를 제출합니다. 테스트는 직접 호출과 `assert`로 작성하며, 빈 `main()`의 실행 성공을 검증으로 기록하지 않습니다.

```sh
./scripts/run-cpp.sh cpp/leetcode/1-two-sum.cpp
```

예시 경로는 실제 풀이가 아닙니다. 해당 디렉터리와 소스 파일을 만들고 문제를 구현한 뒤 실행합니다. 빈 디렉터리는 Git에서 추적하지 않습니다. 여러 풀이를 한 실행 파일로 링크하지 않고 지정한 파일 하나만 컴파일합니다. `CXX=g++ ./scripts/run-cpp.sh <파일>`로 컴파일러를 변경할 수 있습니다.

VS Code에서는 `.cpp` 파일을 연 상태에서 기본 빌드 작업(`Cmd+Shift+B` / `Ctrl+Shift+B`)을 실행합니다. 표준 입력은 열린 터미널에 입력합니다.

## C++ 코드 스타일

`.clang-format`은 들여쓰기 4칸과 최대 100열을 사용합니다. `clang-format` 설치 후 다음처럼 적용합니다.

```sh
clang-format -i cpp/leetcode/1-two-sum.cpp
```

## 기존 BOJ 풀이

[Java 풀이](java/legacy-boj/)는 보관하고, 복습할 문제만 `cpp/boj/`에 새로 작성합니다. 원문이나 온라인 채점기를 사용할 수 없다면 확보한 명세에 따라 로컬 테스트를 작성하고 그 검증 범위를 기록합니다.

과거 BOJ 프로필: https://www.acmicpc.net/user/kwondo1017

## 커밋 규칙

- 커밋 제목과 본문은 한글로 작성합니다. 플랫폼 식별자, 문제 번호와 코드 이름은 그대로 사용합니다.
- 풀이 변경은 문제 하나를 커밋 하나의 단위로 합니다. 해당 문제의 테스트와 설명은 함께 포함합니다.
- 같은 문제의 후속 수정은 별도 커밋으로 남깁니다.
- 환경과 구조 변경은 관련 파일을 하나의 목적에 맞춰 묶습니다.
- 기존 커밋 이력은 보존하고 이 규칙은 이번 구조 변경부터 적용합니다.

제목 예시: `BOJ 1931 풀이 추가`, `LeetCode 1 경계 조건 수정`, `C++ 실행 오류 처리 개선`.
