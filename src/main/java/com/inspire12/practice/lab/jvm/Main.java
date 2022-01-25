// javac Main.java
// java -verbose:class Main

// shorturl.at/nsuT7
class Main {
    public static void main(String[] args) {
        new Single();
    }
}

class Single {
    // 1. 생성자
    public Single() {}

    // 2. 정적 변수 - final X
    public static int a;

    // 3. 정적 변수 - final O
    public static final int b = 0;

    // 4. 정적 메서드
    public static void getInstance() {
    }

    // 5. 정적 내부 클래스
    public static class Holder {
        public static Single INSTANCE;
    }
}