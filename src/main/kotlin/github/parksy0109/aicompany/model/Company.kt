package github.parksy0109.aicompany.model

data class Company(
    val name: String,
    val description: String,
    val introduction: List<String>,
    val reference: List<String>,
    val image: String,
)

val companies = mapOf(
    "가제트팩토리" to
            Company(
                "가제트 팩토리",
                "성과형 모바일 마케팅 회사",
                listOf(
                    "150개 이상의 매체와 연동되어 신속한 광고 집행 가능",
                    "실시간 광고 최적화 수행",
                    "24시간 자동 모니터링 가능 (광고 사기 최대한 방지 & 광고 효율 극대화)"
                ),
                listOf(
                    "https://www.etoday.co.kr/news/view/1917453",
                    "https://brunch.co.kr/@cheolhwanch/22"
                ),
                "../images/gazet_factory.png"
            ),
    "NationA" to
            Company(
                "NationA",
                "3D 모션 컨텐츠 솔루션",
                listOf(
                    "AI 기반 3D 모션 데이터 생성 기술",
                    "로봇 시뮬레이션 소프트웨어",
                ),
                listOf(
                    "https://www.saramin.co.kr/zf_user/company-info/view/csn/NnNJVDBrUnFyT1U4VndTMGlQV0tvUT09/company_nm/(주)네이션에이",
                    "https://www.wbridge.or.kr/platform/careersport/devcase/selectDevlopCaseDetail.do?ntt_sn=100477"
                ),
                "../images/nation_a.png"
            ),
    "스프링클라우드" to
            Company(
                "스프링클라우드",
                "자율주행, 인공지능 빅데이터를 기반으로 미래 사회를 변화시키는 기업",
                listOf(
                    "모빌리티 플랫폼 - L4/L5 구간 자율주행 풀스택 SW 기반으로 핵심 제품과 다양한 솔루션 개발",
                    "자율주행 SW 솔루션 - 오픈소스 기반의 모든 모빌리티 인지와 제어를 통합으로 클라우드 기반의 서비스 환경 구축",
                    "Service.Auto - 자율주행을 위한 Total Tool kit 제공하여 고객사가 서비스를 빠르게 구축할 수 있는 생태계 제공"
                ),
                listOf(
                    "http://www.aspringcloud.com/",
                ),
                "../images/spring_cloud.png"
            ),
    "꿈많은청년들" to
            Company(
                "꿈많은청년들",
                "챗봇 + 채팅상담센터 솔루션 개발 전문기업",
                listOf(
                    "챗봇을 통한 고객 서비스 자동화 서비스",
                    "사내 챗봇",
                    "올인원 인사관리 “오늘의 업무\" 서비스"
                ),
                listOf(
                    "https://dreamyoungs.com/",
                ),
                "../images/many_dream_young_people.png"
            ),
    "리얼위드" to
            Company(
                "리얼위드",
                "AI 기반의 AR 및 VR 솔루션 기업",
                listOf(
                    "공간센서와 융합한 멀티 AR RAS",
                    "Realwith Active Reality Area - 동선 유도형 솔루션",
                    "X-MES 확장현실기반 멀티플레잉 교육 시스템"
                ),
                listOf(
                    "https://www.realwith.com/",
                ),
                "../images/real_with.png"
            ),
    "스톤랩" to
            Company(
                "스톤랩",
                "인공지능 특화기술 기반 Cyber-Physical System 확장",
                listOf(
                    "다양한 의료 빅데이터의 심층 학습을 통해 의료 진단 보조 서비스 제공",
                    "더마플러스 - 생체지표를 이용 분석하는 피부질환 진단 보조 서비스",
                    "뉴로플러스 - 뇌파 생체지표를 통한 인지장애 진단 보조 서비스"
                ),
                listOf(
                    "https://www.facebook.com/AIYANGJAEHUB.supporters/photos/pcb.289228019675185/289227813008539",
                    "https://www.jobkorea.co.kr/Recruit/Co_Read/C/stonelab/Company_name/스톤랩"
                ),
                "../images/stone_lab.png"
            ),
    "딥센트" to
            Company(
                "딥센트",
                "디지털 향기 분야의 선두기업",
                listOf(
                    "디지털 후각 솔루션",
                    "FOD - 사용자의 맞게 향기를 실시간으로 서비스하는 디지털 향기 케어 서비스",
                    "FaaS - 공간 맞춤형 향기 서비스",
                    "FaaS-i - 불면증 개선에 특화된 맞춤형 향기 서비스"
                ),
                listOf(
                    "https://www.deepscent.io/home/",
                ),
                "../images/deep_scent.png"
            ),
    "버즈빌" to
            Company(
                "버즈빌",
                "리워드형 광고 플랫폼",
                listOf(
                    "다이내믹 리워드 - 잠재 고객 발굴, 맞춤형 리워드",
                    "부정광고 차단 - 머신러닝과 다양한 기술로 신뢰도 높은 광고 플랫폼 제공",
                    "광고 인벤토리 - 네이티브, 인터스티셜, 피드, 팝, 잠금화면 등 다양한 UX 제공",
                    "타겟팅 - DMP 기반의 데이터 분석과 다이내믹 리워드로 사용자에게 집중하는 타겟팅",
                    "리타겟팅 - 머신러닝과 다양한 광고 인벤토리로 사용자를 따라가는 리타겟팅"
                ),
                listOf(
                    "https://www.buzzvil.com/",
                ),
                "../images/buzzvil.png"
            ),
    "공뿌마켓" to
            Company(
                "공뿌마켓",
                "공간-브랜드 AI매칭 솔루션 공뿌마켓",
                listOf(
                    "AI를 이용하여 광고할 브랜드와 매장간의 매칭을 통해 브랜드 홍보를 돕는 솔루션",
                ),
                listOf(
                    "https://www.gongbbu.com/",
                ),
                "../images/gong_bbu.png"
            ),
    "딥스튜디오" to
            Company(
                "딥스튜디오",
                "탈중앙화 K-POP 엔터테이먼트",
                listOf(
                    "버츄얼 후먼, 버추얼 아이돌 및 모델 연구 개발",
                ),
                listOf(
                    "http://www.ds-ent.co.kr/",
                    "https://namu.wiki/w/딥스튜디오",
                    "https://www.venturesquare.net/852028"
                ),
                "../images/deep_studio.png"
            ),
    "버즈앤비" to
            Company(
                "버즈앤비",
                "데이터 기반 인플루언서 마케팅 플랫폼(vling)",
                listOf(
                    "유튜버 수익 분석, 시청자 분석, 광고 단가, 광고 제안",
                    "유튜버, 광고 기업 상대로 솔루션을 제공하는 업체",
                ),
                listOf(
                    "https://vling.net/ko",
                ),
                "../images/buzz_beyond.png"
            ),
    "에이아이네이션" to
            Company(
                "에이아이네이션",
                "인공지능 솔루션 플랫폼 개발",
                listOf(
                    "15년간 다양한 산업 프로젝트 수행을 통해 확보한 국내 최대 규모의 인공지능 알고리즘 뱅크 구축",
                ),
                listOf(
                    "https://www.aination.kr/",
                ),
                "../images/ai_nation.png"
            )
)