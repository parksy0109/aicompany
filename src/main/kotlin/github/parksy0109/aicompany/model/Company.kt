package github.parksy0109.aicompany.model

import github.parksy0109.aicompany.model.Stage.*
import github.parksy0109.aicompany.model.TypeOfBusiness.*

enum class TypeOfBusiness {
    B2B, B2C, B2G, G2C, C2C, P2P, NA
}

enum class Stage {
    DEVELOPMENT, PRODUCTION
}

data class Company(
    val name: String,
    val stage: Stage,
    val category: List<String>,
    val description: String,
    val introduction: List<String>,
    val reference: List<String>,
    val image: String,
    val hasWeb: Boolean,
    val hasAndroid: Boolean,
    val hasIos: Boolean,
    val coreTech: String,
    val typeOfBusiness: List<TypeOfBusiness>
)

fun getCategories(): List<String> {
    return companies.map {
        it.value.category
    }.flatten().distinct()
}

fun getCategoryCountData(): Map<String, Int> {
    return companies.map {
        it.value.category
    }.flatten().groupingBy {
        it
    }.eachCount().toList().sortedWith(compareBy { it.second }).toMap()
}

val companies = mapOf(
    "가제트팩토리" to
            Company(
                "가제트 팩토리",
                DEVELOPMENT,
                listOf("AD", "Marketing"),
                "성과형 모바일 마케팅 회사",
                listOf(
                    "150개 이상의 매체와 연동되어 신속한 광고 집행 가능",
                    "실시간 광고 최적화 수행",
                    "24시간 자동 모니터링 가능 (광고 사기 최대한 방지 & 광고 효율 극대화)"
                ),
                listOf(
                    "https://www.etoday.co.kr/news/view/1917453",
                    "https://brunch.co.kr/@cheolhwanch/22",
                    "https://gazetm.com/login"
                ),
                "../images/gazet_factory.png",
                hasWeb = false,
                hasAndroid = false,
                hasIos = false,
                "\"인공지능을 활욜하여 광고의 효율을 극대화하는 기술\"",
                listOf(B2B)
            ),
    "NationA" to
            Company(
                "NationA",
                DEVELOPMENT,
                listOf("3D"),
                "3D 모션 컨텐츠 솔루션",
                listOf(
                    "AI 기반 3D 모션 데이터 생성 기술",
                    "로봇 시뮬레이션 소프트웨어",
                    "9개 특허 출원 논문 5편 발표를 통해 구체화하는 동시에, 지식재산권을 확보"
                ),
                listOf(
                    "https://www.saramin.co.kr/zf_user/company-info/view/csn/NnNJVDBrUnFyT1U4VndTMGlQV0tvUT09/company_nm/(주)네이션에이",
                    "https://www.wbridge.or.kr/platform/careersport/devcase/selectDevlopCaseDetail.do?ntt_sn=100477"
                ),
                "../images/nation_a.png",
                hasWeb = false,
                hasAndroid = false,
                hasIos = false,
                "\"AI 기반 3D 모션 데이터 생성 기술\"",
                listOf(B2B, B2C)
            ),
    "스프링클라우드" to
            Company(
                "스프링클라우드",
                PRODUCTION,
                listOf("SmartCar", "Autonomous Vehicle Platform"),
                "자율주행, 인공지능 빅데이터를 기반으로 미래 사회를 변화시키는 기업",
                listOf(
                    "모빌리티 플랫폼 - L4/L5 구간 자율주행 풀스택 SW 기반으로 핵심 제품과 다양한 솔루션 개발",
                    "자율주행 SW 솔루션 - 오픈소스 기반의 모든 모빌리티 인지와 제어를 통합으로 클라우드 기반의 서비스 환경 구축",
                    "Service.Auto - 자율주행을 위한 Total Tool kit 제공하여 고객사가 서비스를 빠르게 구축할 수 있는 생태계 제공"
                ),
                listOf(
                    "http://www.aspringcloud.com/",
                ),
                "../images/spring_cloud.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = false,
                "\"라이다 인지, 카메라 인지, 바운딩박스로 인지 대상 확인\"",
                listOf(B2B)
            ),
    "꿈많은청년들" to
            Company(
                "꿈많은청년들",
                PRODUCTION,
                listOf("Chatbot", "Big Data"),
                "챗봇 + 채팅상담센터 솔루션 개발 전문기업",
                listOf(
                    "챗봇을 통한 고객 서비스 자동화 서비스",
                    "사내 챗봇",
                    "올인원 인사관리 오늘의 업무 서비스"
                ),
                listOf(
                    "https://dreamyoungs.com/",
                ),
                "../images/many_dream_young_people.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = false,
                "패턴인식, 형태소 분석, 자연어 처리 데이터 학습을 통한 서비스 개발",
                listOf(B2B)
            ),
    "리얼위드" to
            Company(
                "리얼위드",
                PRODUCTION,
                listOf("Chatbot", "Big data", "VR", "AR", "XR"),
                "AI 기반의 AR 및 VR 솔루션 기업",
                listOf(
                    "공간센서와 융합한 멀티 AR RAS",
                    "Realwith Active Reality Area - 동선 유도형 솔루션",
                    "X-MES 확장현실기반 멀티플레잉 교육 시스템"
                ),
                listOf(
                    "https://www.realwith.com/",
                ),
                "../images/real_with.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = true,
                "메타버스에 VR, AR 접목",
                listOf(B2B, B2C)
            ),
    "스톤랩" to
            Company(
                "스톤랩",
                DEVELOPMENT,
                listOf("Biomedical", "Healthcare"),
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
                "../images/stone_lab.png",
                hasWeb = false,
                hasAndroid = false,
                hasIos = false,
                "영상/텍스트/기타 복합 정보 처리에 관한 인공지능 특화기술",
                listOf(B2B)
            ),
    "딥센트" to
            Company(
                "딥센트",
                PRODUCTION,
                listOf("IoT", "Healthcare"),
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
                "../images/deep_scent.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = true,
                "향기의 데이터화",
                listOf(B2B, B2C)
            ),
    "버즈빌" to
            Company(
                "버즈빌",
                PRODUCTION,
                listOf("AD", "Marketing"),
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
                "../images/buzzvil.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = true,
                "맞춤형 광고, 비즈니스 모델에 적합한 광고 형태 제공",
                listOf(B2B)
            ),
    "공뿌마켓" to
            Company(
                "공뿌마켓",
                PRODUCTION,
                listOf("Customer Behavior Data Analysis", "Distribution"),
                "공간-브랜드 AI매칭 솔루션 공뿌마켓",
                listOf(
                    "AI를 이용하여 광고할 브랜드와 매장간의 매칭을 통해 브랜드 홍보를 돕는 솔루션",
                ),
                listOf(
                    "https://www.gongbbu.com/",
                ),
                "../images/gong_bbu.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = false,
                "",
                listOf()
            ),
    "딥스튜디오" to
            Company(
                "딥스튜디오",
                PRODUCTION,
                listOf("Chatbot", "Big data"),
                "탈중앙화 K-POP 엔터테이먼트",
                listOf(
                    "버츄얼 후먼, 버추얼 아이돌 및 모델 연구 개발",
                ),
                listOf(
                    "http://www.ds-ent.co.kr/",
                    "https://namu.wiki/w/딥스튜디오",
                    "https://www.venturesquare.net/852028"
                ),
                "../images/deep_studio.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = false,
                "",
                listOf()
            ),
    "버즈앤비" to
            Company(
                "버즈앤비",
                PRODUCTION,
                listOf("Marketing", "Big data"),
                "데이터 기반 인플루언서 마케팅 플랫폼(vling)",
                listOf(
                    "유튜버 수익 분석, 시청자 분석, 광고 단가, 광고 제안",
                    "유튜버, 광고 기업 상대로 솔루션을 제공하는 업체",
                ),
                listOf(
                    "https://vling.net/ko",
                ),
                "../images/buzz_beyond.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = false,
                "",
                listOf()
            ),
    "에이아이네이션" to
            Company(
                "에이아이네이션",
                PRODUCTION,
                listOf("AI"),
                "인공지능 솔루션 플랫폼 개발",
                listOf(
                    "15년간 다양한 산업 프로젝트 수행을 통해 확보한 국내 최대 규모의 인공지능 알고리즘 뱅크 구축",
                ),
                listOf(
                    "https://www.aination.kr/",
                ),
                "../images/ai_nation.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = false,
                "",
                listOf()
            ),
    "에프앤에스홀딩스" to
            Company(
                "에프앤에스홀딩스",
                PRODUCTION,
                listOf("Fashion", "Beauty"),
                "패션 매거진과 소셜미디어를 융합한 모바일 서비스 플랫폼(FASSKKER)",
                listOf(
                    "3D 기반의 최신 패션 콘텐츠와 패션 피플을 이어주는 서비스",
                    "브랜딩과 퍼포먼스의 통합 디지털 마케팅 커뮤니케이션(IMC)"
                ),
                listOf(
                    "https://fassker.com/",
                ),
                "../images/fassker.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = true,
                "3D 모델링, AR 테크 기술",
                listOf()
            ),
    "오아시스비즈니스" to
            Company(
                "오아시스비즈니스",
                DEVELOPMENT,
                listOf("PropTech", "Fintech"),
                "AI 상권분석 기반 프롭핀테크 스타트업",
                listOf(
                    "CREMAO - 부동산 개발 업체의 토지 분석 업무를 자동화하여 부동산 사업 타당성 보고서 생성",
                    "ACSS - 소상공인의 사업성을 평가하도록 돕는 대안신용평가 모형",
                    "ittang - 가상 창업 메타버스 앱"
                ),
                listOf(
                    "https://oasisbusiness.co.kr/",
                ),
                "../images/oasis_business.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = true,
                "",
                listOf()
            ),
    "온굿플레이스" to
            Company(
                "온굿플레이스",
                DEVELOPMENT,
                listOf("Chatbot", "Big data"),
                "인공지능기반 소셜 빅데이터 분석 (서비스명: 모객의달인)",
                listOf(
                    "모객의 달인 - 소셜빅데이터 분석을 통해 예비 창업자들을 위한 새로운 상권분석 서비스를 제공",
                    "ELMA Insight - 주소입력만으로 주변 온라인 상권을 파악",
                    "TBA Insight - 여행객들의 행동분석과 AI스케줄링까지 지원",
                    "Local O2O Platform - 개별배달 시스템, 멀티 시장 장보기 시스템"
                ),
                listOf(
                    "https://sites.google.com/view/ogpai/home?authuser=0",
                ),
                "../images/on_good_place.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = true,
                "",
                listOf()
            ),
    "와트" to
            Company(
                "와트",
                DEVELOPMENT,
                listOf("AR", "VR"),
                "AR(증강현실)을 이용하여 스마트글라스 기반으로 산업용 솔루션을 제공",
                listOf(
                    "와트톡 - 영상통화로 업무처리를 신속하게 도와주는 솔루션",
                    "AR Post-it - AI를 이용한 증강현실 데이터 이력관리",
                    "WATT MEMO - 딥러닝 음성인식(Voice To Text)",
                ),
                listOf(
                    "https://wattsolution.co.kr/",
                ),
                "../images/watt.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = false,
                "",
                listOf()
            ),
    "이모티브" to
            Company(
                "이모티브",
                DEVELOPMENT,
                listOf("Digital Healthcare", "Big Data"),
                "아동 ADHD를 위한 디지털치료제",
                listOf(
                    "게임 개발",
                    "헬스케어 -> 정신건강",
                    "안드로이드 모바일 앱 개발 중",
                ),
                listOf(
                    "https://thevc.kr/emotiv",
                ),
                "../images/emotiv.png",
                hasWeb = false,
                hasAndroid = true,
                hasIos = false,
                "모바일 게임을 이용한 훈련을 통한 ADHD 치료를 위한 디지털 통합 솔루션",
                listOf(B2C)
            ),
    "인포플라" to
            Company(
                "인포플라",
                DEVELOPMENT,
                listOf("AI"),
                "인공지능 기반 IT운영 자동화 로봇 서비스",
                listOf(
                    "인공지능 기반 S/W 솔루션 개발 및 서비스 전문기",
                    "ITOM - IT 서비스 및 인프라를 모니터링 및 제어, 정상동작 및 장애 예방에 필요한 업무들을 자동화",
                    "인공지능RPA - 사람이 수행하는 반복적인 업무를 컴퓨터가 대신할 수 있도록 하는 인공지능 솔루션",
                    "Digital Archive - 업무중에 생산 및 수집되는 다양한 자료를 관리하며, 서비스 연계할 수 있게 도와주는 프레임워크 기술"
                ),
                listOf(
                    "https://infofla.modoo.at/",
                ),
                "../images/infofla.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = false,
                "",
                listOf()
            ),
    "케이엠에듀" to
            Company(
                "케이엠에듀",
                DEVELOPMENT,
                listOf("Edu Tech"),
                "소원영어 컨텐츠 제작 및 서비스 / 영어교육 인공지능 SSAI 앱 개발",
                listOf(
                    "학문적인 학습이 아닌 소통을 목적으로 하는 언어로서의 영어 학습 제공",
                    "CFM(Conversion Flow Method) - 문법적인 해석 없이 자연스럽게 영어 문장을 듣고 이해할 수 있도록 유도하는 교수법",
                ),
                listOf(
                    "https://sooneenglish.co.kr/",
                ),
                "../images/kmedu.png",
                hasWeb = true,
                hasAndroid = false,
                hasIos = false,
                "",
                listOf()
            ),
    "큐브로이드" to
            Company(
                "큐브로이드",
                DEVELOPMENT,
                listOf("Edu Tech"),
                "어린이용 스마트 AI 로봇과 코딩 블록을 설계하고 제조하는 AI 및 로보틱스 기업",
                listOf(
                    "Cubroid - 과학 지식을 향상하고 협업 기술을 개발하며 문제 해결에 대한 창의성을 향상",
                    "큐로 AI - 방대한 AI 학습 도구로 모델을 훈련하고 학습하여 Scratch 프로젝트를 코딩하고 그 결과를 Cubroid 로봇으로 직접 확인",
                    "AI 코딩 블록 ARTIBO",
                ),
                listOf(
                    "https://www.cubroid.com/",
                ),
                "../images/cubroid.png",
                hasWeb = true,
                hasAndroid = true,
                hasIos = true,
                "",
                listOf()
            )
)