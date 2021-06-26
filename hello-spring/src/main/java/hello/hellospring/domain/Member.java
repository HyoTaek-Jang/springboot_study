package hello.hellospring.domain;

import javax.persistence.*;

@Entity
// jpa가 관리하는 엔티티
public class Member {

//    얘가 pk야! 그리고 제너레이트 벨류임. 자동으로 올라감 AI같음
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "username") 이렇게하면 하단 칼럼을 username이라고 판단함.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
