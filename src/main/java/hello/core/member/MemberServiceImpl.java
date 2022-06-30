package hello.core.member;

public class MemberServiceImpl implements  MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    //appconfig 사용
    private final MemberRepository memberRepository;

    //생성자 만듬
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //appconfig 사용

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
