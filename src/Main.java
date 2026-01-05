public class Main {
    public static void main(String[] args) {
        OrderManage orderManage = new OrderManage();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        BeverageMaker beverageMaker = new BeverageMaker();

        orderManage.takeOrder("아메리카노");
        paymentProcessor.processPayment(4500);

        Beverage americano = new Americano();
        beverageMaker.makeBeverage(americano);

        Beverage smoothie = new Smoothie();
    }
}

class OrderManage {
    public void takeOrder(String beverageName) {
        System.out.println(beverageName + "주문 접수 성공");
    }
}

class PaymentProcessor {
    public void processPayment(int amount) {

        System.out.println(amount + "원 결제 성공");
    }
}

class BeverageMaker {
    public void makeBeverage(Beverage beverage) {

        beverage.prepare();
    }
}

interface Beverage {
    void prepare();
}

interface Grindable {
    void grindBeans();
}

interface Blendable {
    void blendFruits();
}

class Americano implements Beverage, Grindable {
    public void prepare() {
        grindBeans();
        System.out.println("아메리카노를 내리고 있습니다");
    }
    public void grindBeans() {

        System.out.println("원두를 갈고 있습니다");
    }
}

class Smoothie implements Beverage, Blendable {
    public void prepare() {
        blendFruits();
        System.out.println("스무디를 완성했습니다");
    }
    public void blendFruits() {

        System.out.println("과일을 블렌딩 중입니다");
    }
}