package es.izertis.kata.bowling;

public class BowlingGame {
    private int[] rolls = new int[21]; //Array que permitirá almacenar el resultado de las tiradas adicionales en el caso de strike o spare.
    private int currentRoll = 0; //Contador

    public void roll(int pins) {
        rolls[currentRoll++] = pins; //Número de bolos derribados en la tirada
    }
    /* ===============  Métodos auxiliares  ==================== */
    public boolean isStrike(int frameIndex) {        //Comprueba si se ha efectuado un Pleno
        return rolls[frameIndex] == 10;
    }
    
    public boolean isSpare(int frameIndex) {         //Comprueba si se ha efectuado un Semipleno
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
    
    public int strikeBonus(int frameIndex) {        //Suma el bonus de Pleno
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }
    
    public int spareBonus(int frameIndex) {         //Suma el bonus de Semipleno
        return rolls[frameIndex + 2];
    }
    
    public int sumOfBallsInFrame(int frameIndex) {  //Suma los resultados de las dos tiradas de un turno
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
    /* =============  Fin de métodos auxiliares  ================= */

    public int getScore() {
        int score = 0;
        int frameIndex = 0;
    
        for (int frame = 0; frame < 10; frame++) {
            score += isStrike(frameIndex) ? 10 + strikeBonus(frameIndex) :
                     isSpare(frameIndex) ? 10 + spareBonus(frameIndex) :
                     sumOfBallsInFrame(frameIndex);
    
            frameIndex += isStrike(frameIndex) ? 1 : isSpare(frameIndex) ? 2 : 2;
        }
    
        return score;
    }
    


}
