/* problem
 데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]으로 구성되어 있으며
 현식이는 이 데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬하려 합니다.
 data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후,
 sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution1 {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extColumnNumber = Column.match(ext);
        int sortColumnNumber = Column.match(sort_by);

        List<int[]> dataList = new ArrayList<>();
        for (int[] d : data) {
            if (d[extColumnNumber] < val_ext) {
                dataList.add(d);
            }
        }

        Collections.sort(dataList, (d1, d2) -> d1[sortColumnNumber] - d2[sortColumnNumber]);

        int[][] answer = new int[dataList.size()][4];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dataList.get(i);
        }

        return answer;
    }

    private enum Column {
        CODE("code", 0),
        DATE("date", 1),
        MAXIMUM("maximum", 2),
        REMAIN("remain", 3);

        private final String ext;
        private final int columnNumber;

        Column(String ext, int columnNumber) {
            this.ext = ext;
            this.columnNumber = columnNumber;
        }

        public static int match(String ext) {
            return Arrays.stream(values())
                    .filter(column -> column.ext.equals(ext))
                    .findFirst()
                    .orElseThrow()
                    .columnNumber;
        }
    }
}

class Solution2 {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extColumnNumber = Column.match(ext);
        int sortColumnNumber = Column.match(sort_by);

        return Arrays.stream(data)
                .filter(d -> d[extColumnNumber] < val_ext)
                .sorted((d1, d2) -> d1[sortColumnNumber] - d2[sortColumnNumber])
                .toArray(int[][]::new);
    }

    private enum Column {
        CODE("code", 0),
        DATE("date", 1),
        MAXIMUM("maximum", 2),
        REMAIN("remain", 3);

        private final String ext;
        private final int columnNumber;

        Column(String ext, int columnNumber) {
            this.ext = ext;
            this.columnNumber = columnNumber;
        }

        public static int match(String ext) {
            return Arrays.stream(values())
                    .filter(column -> column.ext.equals(ext))
                    .findFirst()
                    .orElseThrow()
                    .columnNumber;
        }
    }
}

// strategy
// stream
// sort

// ext -> code = 0, date = 1, maximum = 2, remain =3
// ext 값이 val_ext 보다 작은 데이터
// sort_by 로 오름차순 정렬
