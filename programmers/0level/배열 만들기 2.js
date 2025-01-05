function solution(l, r) {
    let answer = [];

    for (let i = l; i <= r; i++) {
        const split = String(i).split("");
        let flag = false;
        for (const s of split) {
            if (s !== '0' && s !== '5') {
                flag = true;
                break;
            }
        }
        if (!flag) {
            answer.push(i);
        }
    }

    if (answer.length === 0) {
        return [-1];
    }

    return answer;
}
