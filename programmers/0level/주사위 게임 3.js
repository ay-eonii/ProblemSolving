function solution(a, b, c, d) {
    const map = new Map();
    const arr = [a, b, c, d];
    for (let i = 0; i < 4; i++) {
        const value = map.get(arr[i]);
        if (value) {
            map.set(arr[i], value + 1);
        } else {
            map.set(arr[i], 1);
        }
    }

    const keys = [...map.keys()];

    if (keys.length === 1) {
        return 1111 * keys[0];
    }

    if (keys.length === 4) {
        return Math.min(a, b, c, d);
    }

    if (keys.length === 3) {
        const v = keys.filter(k => map.get(k) === 1);
        return v[0] * v[1];
    }

    if (map.get(a) === 2) {
        return (keys[0] + keys[1]) * Math.abs(keys[0] - keys[1]);
    }

    if (map.get(keys[0]) === 3) {
        return Math.pow(10 * keys[0] + keys[1], 2);
    }
    return Math.pow(10 * keys[1] + keys[0], 2);
}

// Map
