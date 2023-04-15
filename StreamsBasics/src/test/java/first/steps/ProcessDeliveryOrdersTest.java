package first.steps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

public class ProcessDeliveryOrdersTest {

    private static List<DeliveryOrder> orders;

    @BeforeAll
    static void beforeAll() {
        orders = List.of(
                new DeliveryOrder(1L, "112 Mammoth Street, Colorado Springs, CO 80911",
                        LocalDate.of(2021, 9, 3)),
                new DeliveryOrder(2L, "369 Woodside Court, Troy, NY 12180",
                        LocalDate.of(2021, 9, 5)),
                new DeliveryOrder(3L, "837 Bowman Street, Helena, MT 59601",
                        LocalDate.of(2021, 9, 2)),
                new DeliveryOrder(4L, "112 Mammoth Street, Colorado Springs, CO 80911",
                        LocalDate.of(2021, 9, 3))
        );
    }

    @Test
    void findFirstOrderTest() {

        var expected = new DeliveryOrder(3L, "837 Bowman Street, Helena, MT 59601",
                LocalDate.of(2021, 9, 2));
        var actual = ProcessDeliveryOrders.findFirstOrder(orders);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void printAddressesToDeliverTest() {

        try {
            String result = tapSystemOut(() -> ProcessDeliveryOrders.printAddressesToDeliver(orders));
            assertThat(result).isEqualTo("""
                837 Bowman Street, Helena, MT 59601
                112 Mammoth Street, Colorado Springs, CO 80911
                369 Woodside Court, Troy, NY 12180
                                                """);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
