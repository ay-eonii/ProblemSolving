function solution(x, n) {
    return Array(n).fill(x).map((e, i) => (i + 1) * e);
}

// x: 시작, 증가
// n개
