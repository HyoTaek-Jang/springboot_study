package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member byId = memberRepository.findById(memberID);
        int discount = discountPolicy.discount(byId, itemPrice);
        return new Order(memberID, itemName, itemPrice, discount);
    }
}
