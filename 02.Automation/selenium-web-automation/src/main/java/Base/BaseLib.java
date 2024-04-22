package Base;

import java.util.Random;

public class BaseLib extends Data {
    public int createRandomNumber (int length){
        Random random= new Random();
        return random.nextInt(length);
    }
}
