package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총 합이 10000원 이상이도록 입력해주세요")
public class Item {
    // 수정 요구사항: id notNull, quantity no limit
//    @NotNull(groups = UpdateCheck.class)
    private Long id;

//    @NotBlank(groups = {SaveCheck.class,UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {SaveCheck.class,UpdateCheck.class})
//    @Range(min= 1000, max = 1000000,groups = {SaveCheck.class,UpdateCheck.class})
    private Integer price;

//    @NotNull(groups = {SaveCheck.class,UpdateCheck.class})
//    @Range(max = 9999,groups = SaveCheck.class)
    private Integer quantity;


    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
