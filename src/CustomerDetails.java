import java.io.ObjectStreamClass;
import java.util.Objects;

public class CustomerDetails {
    private String customerName;
    private long phoneNumber;
    private String address;

    public CustomerDetails(String customerName, long phoneNumber, String address) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

abstract class Bero {
    protected String beroType;
    protected String beroColor;
    protected double price;

    Bero(String beroType, String beroColor) {
        this.beroType = beroType;
        this.beroColor = beroColor;
    }

    public void setBeroType(String beroType) {
        this.beroType = beroType;
    }

    public String getBeroType() {
        return beroType;
    }

    public void setBeroColor(String beroColor) {
        this.beroColor = beroColor;
    }

    public String getBeroColor() {
        return beroColor;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public abstract void calculatePrice();
}

class SteelBero extends Bero {
    private int beroHeight;

    public SteelBero(String beroType, String beroColor, int beroHeight) {
        super(beroType, beroColor);
        this.beroHeight = beroHeight;
    }

    public void setBeroHeight(int beroHeight) {
        this.beroHeight = beroHeight;
    }
    public int getBeroHeight() {
        return beroHeight;
    }

    public void calculatePrice() {
        if (beroHeight==3) {
            setPrice(5000);
        } else if (beroHeight==5) {
            setPrice(8000);
        } else if (beroHeight==7) {
            setPrice(10000);
        }
    }
}

class WoodenBero extends Bero {
    private String woodType;

    WoodenBero(String beroType, String beroColor, String woodType) {
        super(beroType, beroColor);
        this.woodType = woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getWoodType() {
        return woodType;
    }

    public void calculatePrice() {
        if (Objects.equals(woodType, "Ply Wood")) {
            setPrice(15000);
        } else if (Objects.equals(woodType,"Teak Wood")) {
            setPrice(12000);
        } else if (Objects.equals(woodType,"Engineered Wood")) {
            setPrice(10000);
        }
    }
}

class Discount {
    public double calculateDiscount(Bero beroObject) {
        double discount=0.0;
        if (Objects.equals(beroObject.getBeroType(), "Steel Bero")) {
            discount = (beroObject.getPrice() * 10) / 100;
        } else if (Objects.equals(beroObject.getBeroType(), "Wooden Bero")) {
            discount = (beroObject.getPrice() * 15) / 100;
        }
        return discount;
    }
}

