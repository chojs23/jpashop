package jpabook.jpashop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "member") //일대다 관계 //Order table 에 있는 member 필드에 의해 mapping 됨
    //연관관계 주인 아님 맵핑된 애
    private List<Order> orders = new ArrayList<>();

}
