function solution(s) {

    var answer = [0, 0];
    let result = s;
    while (result !== "1") {
        var len = result.replaceAll("0", "").length;
        answer[0]++;
        answer[1] += result.length - len;
        result = len.toString(2);
    }

    return answer;
}

// 111111 -> 6 -> 110
