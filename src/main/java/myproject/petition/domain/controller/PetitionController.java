package myproject.petition.domain.controller;

import lombok.RequiredArgsConstructor;
import myproject.petition.domain.info.Info;
import myproject.petition.domain.info.PetitionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class PetitionController {

    private final PetitionRepository petitionRepository;

    @GetMapping
    public String main(Model model){
        List<Info>petitions = petitionRepository.findAll();
        model.addAttribute("petitions", petitions);
        return "basic/main";
    }

    @GetMapping("/{petitionId}")
    public String petition(@PathVariable Long petitionId, Model model){
        Info petition = petitionRepository.findById(petitionId);
        model.addAttribute("petition", petition);
        return "/basic/petition";
    }

    @GetMapping("/write")
    public String write(){
        return "/basic/write";
    }

    @PostMapping("/write")
    public String writePetition(Info info, RedirectAttributes redirectAttributes){
        Info savedPetition = petitionRepository.save(info);
        redirectAttributes.addAttribute("petitionId", savedPetition.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/{petitionId}";
    }

    @GetMapping("/{petitionId}/edit")
    public String edit(@PathVariable Long petitionId, Model model){
        Info petition = petitionRepository.findById(petitionId);
        model.addAttribute("petition", petition);
        return "/basic/editPetition";
    }

    @PostMapping("/{petitionId}/edit")
    public String editPetition(@PathVariable Long petitionId, @ModelAttribute Info info){
        petitionRepository.updateInfo(petitionId, info);
        return "redirect:/{petitionId}";
    }



    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        petitionRepository.save(new Info("드라마 설** 방영중지 청원", "문화/예술/체육/언론",
                "해당 드라마는 방영 전 이미 시놉시스 공개로 한차례 민주화운동을 폄훼하는 내용으로 큰 논란이 된 바 있으며 20만명 이상의 국민들이 해당 드라마의 방영 중지 청원에 동의하였습니다. 당시 제작진은 전혀 그럴 의도가 없으며 “남녀 주인공이 민주화 운동에 참여하거나 이끄는 설정은 대본 어디에도 존재하지 않는다.” 라고 주장했습니다. 그러나 1화가 방영된 현재 드라마에서 여주인공은 간첩인 남주인공을 운동권으로 오인해 구해주었습니다.\n" +
                "\n" +
                "민주화운동 당시 근거없이 간첩으로 몰려서 고문을 당하고 사망한 운동권 피해자들이 분명히 존재하며 이러한 역사적 사실에도 불구하고 저런 내용의 드라마를 만든 것은 분명히 민주화운동의 가치를 훼손시키는 일이라고 생각합니다. 뿐만 아니라 간첩인 남자주인공이 도망가며, 안기부인 서브 남주인공이 쫓아갈 때 배경음악으로 ‘솔아 푸르른 솔아’ 가 나왔습니다. 이 노래는 민주화운동 당시 학생운동 때 사용되었던 노래이며 민주화운동을 수행하는 사람들의 고통과 승리를 역설하는 노래입니다. 그런 노래를 1980년대 안기부를 연기한 사람과 간첩을 연기하는 사람의 배경음악으로 사용한 것 자체가 용인될 수 없는 행위입니다. 뿐만 아니라 해당 드라마는 ott서비스를 통해 세계 각 국에서 시청할 수 있으며 다수의 외국인에게 민주화운동에 대한 잘못된 역사관을 심어줄 수 있기에 더욱 방영을 강행해서는 안 된다고 생각합니다.\n" +
                "\n" +
                "한국은 엄연한 민주주의 국가이며 이러한 민주주의는 노력없이 이루어진 것이 아닌, 결백한 다수의 고통과 희생을 통해 쟁취한 것입니다. 이로부터 고작 약 30년이 지난 지금, 민주화운동의 가치를 훼손하는 드라마의 방영은 당연히 중지되어야 하며 한국문화의 영향력이 점차 커지고 있는 현 시점에서 방송계 역시 역사왜곡의 심각성에 대해 다시 한번 생각해 봤으면 합니다.\n"));

        petitionRepository.save(new Info("외국 국적 여중생을 묶고 6시간 가학적 집단폭행한 가해자4명 강력처벌.신상공개를촉구합니다.", "인권/성평등",
                "외국 국적 여중생을 집단 폭행하고 학대한 또래 중학생 4명이 경찰에 붙잡혔다.\n" +
                        "\n" +
                        "경남 **경찰서는 1일 중학교 1학년인 외국 국적 A(14)양을 폭행한 중학생 4명 중 2명을 촉법소년으로 소년부에 송치하고 2명은 폭행 혐의를 적용에 검찰에 넘겼다고 밝혔다.\n" +
                        "\n" +
                        "이들은 지난 7월 A양의 몸을 묶은 채 속옷 차림으로 폭행한 혐의를 받는다. 본지 취재를 종합하면 A양은 가정 불화로 가출한 뒤 알게 된 가해 학생 중 1명인 B양 집에 머물렀다. 이후 가출한 A양을 찾던 친척이 B양을 때렸고, B양 등 일행 4명은 이에 대한 보복으로 A양을 폭행한 것으로 알려졌다.\n" +
                        "\n" +
                        "가해 학생들은 폭행을 하며 A양의 국적을 비하하기도 한 것으로 전해졌다. 경찰 조사 결과 당시 가해 학생과 피해 학생 모두 술에 취한 상태였고, 집단 폭행은 밤 12시부터 6시간 동안 이어진 것으로 전해졌다.\n" +
                        "\n" +
                        "경남도교육청과 경찰은 A양의 피해 경위를 정확히 조사하는 한편 A양 친척이 다른 학생에게 상처를 입힌 사실에 대해서도 조사 중이다.\n" +
                        "\n" +
                        "경남 **경찰서는 1일 중학교 1학년인 외국 국적 A(14)양을 폭행한 중학생 4명 중 2명을 촉법소년으로 소년부에 송치하고 2명은 폭행 혐의를 적용에 검찰에 넘겼다고 밝혔다.\n" +
                        "\n" +
                        "이들은 지난 7월 A양의 몸을 묶은 채 속옷 차림으로 폭행한 혐의를 받는다. 본지 취재를 종합하면 A양은 가정 불화로 가출한 뒤 알게 된 가해 학생 중 1명인 B양 집에 머물렀다. 이후 가출한 A양을 찾던 친척이 B양을 때렸고, B양 등 일행 4명은 이에 대한 보복으로 A양을 폭행한 것으로 알려졌다.\n" +
                        "\n" +
                        "가해 학생들은 폭행을 하며 A양의 국적을 비하하기도 한 것으로 전해졌다. 경찰 조사 결과 당시 가해 학생과 피해 학생 모두 술에 취한 상태였고, 집단 폭행은 밤 12시부터 6시간 동안 이어진 것으로 전해졌다.\n" +
                        "\n" +
                        "경남도교육청과 경찰은 A양의 피해 경위를 정확히 조사하는 한편 A양 친척이 다른 학생에게 상처를 입힌 사실에 대해서도 조사 중이다.\n" +
                        "\n" +
                        "가해 학생과 피해 학생 모두 술에 취한 상태였고, 집단 폭행은 밤 12시부터 새벽까지 6시간 동안 이어진 것으로 조사됐다.\n" +
                        "\n" +
                        "강력수사 후 이 가해자 4명을 강력 처벌과 신상 공개를 요청합니다 만약 안 될 시 이 가해자들 부모를 강력 처벌을 요청합니다\n" +
                        "\n" +
                        "[본 게시물의 일부 내용이 국민 청원 요건에 위배되어 관리자에 의해 수정되었습니다]"));
    }
}
