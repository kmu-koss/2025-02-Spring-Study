// 음료 인터페이스
interface Beverage {
    String getName();
    double getPrice();
    void prepare();
}

// 커피 관련 인터페이스
interface Grindable {
    void grindBeans();
}

// 스무디 관련 인터페이스
interface Blendable {
    void blendFruits();
}

// 커피 클래스
class Coffee implements Beverage, Grindable {
    private String name;
    private double price;

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void grindBeans() {
        System.out.println("원두를 갈고 있습니다...");
    }

    @Override
    public void prepare() {
        System.out.println("[ " + name + " 제작 중 ]");
        grindBeans();
        System.out.println("커피를 추출하고 있습니다...");
        System.out.println(name + " 완성");
    }
}

// 스무디 클래스
class Smoothie implements Beverage, Blendable {
    private String name;
    private double price;

    public Smoothie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void blendFruits() {
        System.out.println("과일을 갈고 있습니다...");
    }

    @Override
    public void prepare() {
        System.out.println("[ " + name + " 제작 중 ]");
        blendFruits();
        System.out.println("스무디를 갈고 있습니다...");
        System.out.println(name + " 완성");
    }
}

// 음료 제작
class BeverageMaker {
    public void make(Beverage beverage) {
        beverage.prepare();
    }
}

// 결제 처리
class PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("[ 결제 ]");
        System.out.println("결제 금액 : " + amount +"원");
        System.out.println("결제 완료");
    }
}

// 주문 접수
class OrderManage {
    private BeverageMaker beverageMaker;
    private PaymentProcessor paymentProcessor;

    public OrderManage() {
        this.beverageMaker = new BeverageMaker();
        this.paymentProcessor = new PaymentProcessor();
    }

    public void placeOrder(Beverage beverage) {
        System.out.println("\n============ 주문 시작 ============");
        System.out.println("주문 음료: " + beverage.getName());
        System.out.println("가격: " + beverage.getPrice() + "원\n");

        // 음료 제작
        beverageMaker.make(beverage);

        System.out.println();

        // 결제 처리
        paymentProcessor.processPayment(beverage.getPrice());

        System.out.println("\n============ 주문 완료 ============");
    }
}

public class Kiosk {
    public static void main(String[] args) {
        OrderManage kiosk = new OrderManage();

        Beverage americano = new Coffee("americano", 4500);
        Beverage latte = new Coffee("latte", 5800);
        Beverage strawberrySmoothie = new Smoothie("strawberrySmoothie", 5500);
        Beverage blueberrySmoothie = new Smoothie("blueberrySmoothie", 5500);

        kiosk.placeOrder(americano);
        kiosk.placeOrder(latte);
        kiosk.placeOrder(strawberrySmoothie);
        kiosk.placeOrder(blueberrySmoothie);
    }
}