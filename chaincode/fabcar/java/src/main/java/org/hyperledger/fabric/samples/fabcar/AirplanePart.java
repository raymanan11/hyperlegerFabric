import java.util.Objects;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.owlike.genson.annotation.JsonProperty;

@DataType()
public final class AirlinePart {

    @Property()
    private final String make;

    @Property()
    private final String model;

    @Property()
    private final String modelNumber;

    @Property()
    private final String owner;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getOwner() {
        return owner;
    }

    public Car(@JsonProperty("make") final String make, @JsonProperty("model") final String model,
            @JsonProperty("modelOwner") final String modelNumber, @JsonProperty("owner") final String owner) {
        this.make = make;
        this.model = model;
        this.modelNumber = modelNumber;
        this.owner = owner;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Car other = (Car) obj;

        return Objects.deepEquals(new String[] {getMake(), getModel(), getModelNumber(), getOwner()},
                new String[] {other.getMake(), other.getModel(), other.getModelNumber(), other.getOwner()});
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getModelNumber(), getOwner());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " [make=" + make + ", model="
                + model + ", modelNumber=" + modelNumber + ", owner=" + owner + "]";
    }
}
