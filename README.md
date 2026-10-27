# PS

백준(BOJ), 프로그래머스(Programmers), 리트코드(LeetCode) 세 플랫폼의 알고리즘 문제 풀이와 복습을 기록하는 저장소입니다. 새 풀이는 기본적으로 C++17로 작성하며, 기존 Java BOJ 풀이는 보관합니다.

## 구조

```text
cpp/
  boj/              # 1931.cpp
  programmers/      # lvl0-flaf에따라다른값반환하기.cpp
  leetcode/         # 0001-two-sum.cpp
java/
  legacy-boj/       # 기존 Bronze, Silver, Gold Java 풀이
scripts/           # run-cpp.sh, shell-init.sh
.vscode/           # 현재 파일 실행 작업
```

새 언어는 루트에 소문자 언어 폴더를 추가하고 그 아래 `boj/`, `programmers/`, `leetcode/`로 구분합니다. 새 풀이는 난이도나 알고리즘별 하위 폴더 없이 플랫폼 폴더에 저장합니다.

## 폴더명·파일명 규칙

| 플랫폼 | 경로 형식 | 예시 | 커밋 스코프 |
| --- | --- | --- | --- |
| 백준 | `<언어>/boj/<문제번호>.<확장자>` | `cpp/boj/1931.cpp` | `boj` |
| 프로그래머스 | `<언어>/programmers/lvl<레벨>-<문제이름>.<확장자>` | `cpp/programmers/lvl0-flaf에따라다른값반환하기.cpp` | `pg` |
| 리트코드 | `<언어>/leetcode/<4자리-이상-문제번호>-<문제이름>.<확장자>` | `cpp/leetcode/0001-two-sum.cpp` | `lc` |

- 백준 번호는 앞에 0을 붙이지 않습니다.
- 프로그래머스는 문제 번호 대신 `lvl0`, `lvl1`처럼 레벨을 붙이고, 뒤에 한글 또는 영어 문제 이름을 작성합니다. 이름의 공백은 생략하거나 하이픈으로 바꿉니다.
- 리트코드는 문제 화면의 번호를 최소 4자리로 표기합니다. `1`은 `0001`, `12345`는 그대로 `12345`입니다.
- 문제 이름은 플랫폼의 원문 제목을 사용합니다. 영문은 소문자로, 공백(프로그래머스는 생략 가능)과 밑줄은 하이픈(`-`)으로 바꾸고 나머지 특수문자는 제거합니다. 연속 하이픈은 하나로 합치고 양 끝 하이픈은 제거합니다. 한글은 유지합니다.
- 파일명에 `#`이나 플랫폼 접두사를 붙이지 않습니다. 확장자는 언어에 맞게 사용합니다.
- 새 풀이부터 이 규칙을 적용합니다. 기존 LeetCode 파일명과 `java/legacy-boj/`의 경로·파일명은 유지합니다.

알고리즘 태그와 접근, 복잡도, 복습 메모는 각 소스 파일 상단 주석에 기록합니다. 검증 결과는 온라인 제출 통과와 로컬 테스트 통과를 구분합니다.

## C++ 실행

`clang++`와 Bash가 필요합니다. 실행 파일은 Git에서 제외되는 `build/`에 생성됩니다.

짧은 `run` 명령은 셸 초기화 파일을 한 번 불러오면 사용할 수 있습니다.

```sh
source scripts/shell-init.sh
run cpp/boj/1931.cpp < input.txt
run cpp/programmers/lvl0-flaf에따라다른값반환하기.cpp
run cpp/leetcode/0001-two-sum.cpp
```

새 터미널에서도 사용하려면 `~/.zshrc`에 이 저장소의 `scripts/shell-init.sh`를 불러오는 `source` 줄을 추가합니다. 파일 경로는 현재 작업 디렉터리를 기준으로 해석됩니다. 저장소를 이동하면 초기화 경로도 갱신합니다. 소스 경로만 입력하는 대신 `run <파일.cpp>`로 실행합니다.

```sh
./scripts/run-cpp.sh cpp/boj/1931.cpp
# 저장된 입력을 사용할 때
./scripts/run-cpp.sh cpp/boj/1931.cpp < input.txt
```

BOJ 파일에는 표준 입력과 출력을 처리하는 `main()`을 작성합니다. 프로그래머스는 문제에서 제공하는 `solution(...)` 함수 형식을, LeetCode는 `Solution` 클래스 형식을 따릅니다. 두 플랫폼 모두 같은 파일에 `#ifdef LOCAL`로 감싼 테스트용 `main()`을 작성합니다. 스크립트가 `LOCAL`을 정의하여 테스트를 실행합니다. 제출할 때는 문제에서 요구하는 함수나 클래스와 필요한 헤더를 제출합니다. 테스트는 직접 호출과 `assert`로 작성하며, 빈 `main()`의 실행 성공을 검증으로 기록하지 않습니다.

```sh
./scripts/run-cpp.sh cpp/programmers/lvl0-flaf에따라다른값반환하기.cpp
./scripts/run-cpp.sh cpp/leetcode/0001-two-sum.cpp
```

예시 경로는 실제 풀이가 아닙니다. 해당 디렉터리와 소스 파일을 만들고 문제를 구현한 뒤 실행합니다. 빈 디렉터리는 Git에서 추적하지 않습니다. 여러 풀이를 한 실행 파일로 링크하지 않고 지정한 파일 하나만 컴파일합니다. `CXX=g++ ./scripts/run-cpp.sh <파일>`로 컴파일러를 변경할 수 있습니다.

VS Code에서는 `.cpp` 파일을 연 상태에서 기본 빌드 작업(`Cmd+Shift+B` / `Ctrl+Shift+B`)을 실행합니다. 표준 입력은 열린 터미널에 입력합니다.

## C++ 코드 스타일

`.clang-format`은 들여쓰기 4칸과 최대 100열을 사용합니다. `clang-format` 설치 후 다음처럼 적용합니다.

```sh
clang-format -i cpp/leetcode/0001-two-sum.cpp
```

## 기존 BOJ 풀이

[Java 풀이](java/legacy-boj/)는 보관하고, 복습할 문제만 `cpp/boj/`에 새로 작성합니다. 원문이나 온라인 채점기를 사용할 수 없다면 확보한 명세에 따라 로컬 테스트를 작성하고 그 검증 범위를 기록합니다.

과거 BOJ 프로필: https://www.acmicpc.net/user/kwondo1017

## 커밋 규칙

커밋 제목은 `<type>(<scope>): <problem> <description>` 형식을 사용합니다. 새 문제 풀이와 테스트를 함께 추가하면 `solve`, 테스트 코드만 추가·수정하면 `test`를 사용합니다.

- 스코프: 백준 `boj`, 프로그래머스 `pg`, 리트코드 `lc`, 공통 문서·설정 `ps`.
- 타입: 새 풀이 `solve`, 테스트 `test`, 오류 수정 `fix`, 구현 개선 `refactor`, 문서 `docs`, 환경·관리 `chore`.
- 백준·리트코드는 문제 번호, 프로그래머스는 확장자를 제외한 파일명(`lvl<레벨>-<문제이름>`)으로 문제를 식별합니다. 문제와 무관한 변경은 문제 식별자를 생략합니다.
- 풀이 변경은 문제 하나를 커밋 하나의 단위로 하며, 관련 테스트와 설명을 함께 포함합니다.

```text
solve(boj): 1931 회의실 배정
solve(pg): lvl0-flaf에따라다른값반환하기 풀이 추가
solve(lc): 0001 two-sum
test(pg): lvl0-flaf에따라다른값반환하기 조건별 테스트 추가
fix(boj): 1931 종료 시간이 같은 경우 정렬 수정
docs(ps): 세 플랫폼 폴더 및 파일명 규칙 정리
```

타입, 스코프, 문제 식별자와 커밋 단위의 상세 규칙은 [커밋 컨벤션](docs/commit-convention.md)을 참고합니다.
