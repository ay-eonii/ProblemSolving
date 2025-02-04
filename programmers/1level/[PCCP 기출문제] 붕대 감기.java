class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int bandageTime = bandage[0];
        int healPerSecond = bandage[1];
        int extraHeal = bandage[2];

        int currentHealth = health;
        int lastAttackTime = 0;

        for (int[] attack : attacks) {
            int healTime = attack[0] - lastAttackTime - 1;
            int totalHeal = (healTime * healPerSecond) + (healTime / bandageTime) * extraHeal;

            currentHealth = Math.min(health, currentHealth + totalHeal);

            lastAttackTime = attack[0];
            currentHealth -= attack[1];
            if (currentHealth <= 0) {
                return -1;
            }
        }

        return currentHealth;
    }
}

// 초당 x
// t초 연속 -> + y 체력
// bandage: 기술의 시전 시간, 1초당 회복량, 추가 회복량
// health: 최대 체력
// attacks: 몬스터의 공격 시간과 피해량

// 공격기준으로 지난 시간동안 heal
// 이번공격시간 - 지난공격시간 - 1 : (9-2-1=6) => 6초간 heal 가능
// 총 회복량 : (heal 가능 시간 * 초당 회복량) + (heal 가능 시간 / 기술 시전 시간) * 추가회복량
// Math.min(최대체력, 현재체력 + 총 회복량)

// 공격받을 때 현재체력 < 0 이라면 return -1
