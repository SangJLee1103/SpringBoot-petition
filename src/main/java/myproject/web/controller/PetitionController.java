package myproject.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.petition.domain.info.Petition;
import myproject.petition.domain.info.PetitionRepository;
import myproject.web.form.PetitionEditValidation;
import myproject.web.form.PetitionWriteValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class PetitionController {

    private final PetitionRepository petitionRepository;

    @GetMapping
    public String main(Model model){
        List<Petition>petitions = petitionRepository.findAll();
        model.addAttribute("petitions", petitions);
        return "basic/main";
    }

    @GetMapping("/{petitionId}")
    public String petition(@PathVariable Long petitionId, Model model){
        Petition petition = petitionRepository.findById(petitionId);
        model.addAttribute("petition", petition);
        return "/basic/petition";
    }

    @GetMapping("/write")
    public String write(Model model){
        model.addAttribute("petition", new Petition());
        return "/basic/write";
    }

    @PostMapping("/write")
    public String writePetition(@Validated @ModelAttribute("petition") PetitionWriteValidation form, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        //검증에 실패하면 다시 입력 폼으로
        //bindingResult 는 modelAttribute 에 담지 않아도 뷰로 넘어감!
        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
            return "basic/write";
        }

        Petition petition = new Petition();
        petition.setSubject(form.getSubject());
        petition.setField(form.getField());
        petition.setContent(form.getContent());


        Petition savedPetition = petitionRepository.save(petition);
        redirectAttributes.addAttribute("petitionId", savedPetition.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/{petitionId}";
    }

    @GetMapping("/{petitionId}/edit")
    public String edit(@PathVariable Long petitionId, Model model){
        Petition petition = petitionRepository.findById(petitionId);
        model.addAttribute("petition", petition);
        return "/basic/editPetition";
    }

    @PostMapping("/{petitionId}/edit")
    public String editPetition(@PathVariable Long petitionId, @Validated @ModelAttribute("petition") PetitionEditValidation form, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.info("errors={}", bindingResult);
            return "/basic/editPetition";
        }

        Petition petitionParam = new Petition();
        petitionParam.setSubject(form.getSubject());
        petitionParam.setField(form.getField());
        petitionParam.setContent(form.getContent());


        petitionRepository.updatePetition(petitionId, petitionParam);
        return "redirect:/{petitionId}";
    }

    @GetMapping ("/{petitionId}/delete")
    public String deletePetition(@PathVariable Long petitionId, @ModelAttribute Petition petition){
        petitionRepository.deletePetition(petitionId, petition);
        return "/basic/main";
    }


    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        petitionRepository.save(new Petition("드라마 설** 방영중지 청원", "문화/예술/체육/언론",
                "해당 드라마는 방영 전 이미 시놉시스 공개로 한차례 민주화운동을 폄훼하는 내용으로 큰 논란이 된 바 있으며 20만명 이상의 국민들이 해당 드라마의 방영 중지 청원에 동의하였습니다. 당시 제작진은 전혀 그럴 의도가 없으며 “남녀 주인공이 민주화 운동에 참여하거나 이끄는 설정은 대본 어디에도 존재하지 않는다.” 라고 주장했습니다. 그러나 1화가 방영된 현재 드라마에서 여주인공은 간첩인 남주인공을 운동권으로 오인해 구해주었습니다.\n" +
                "\n" +
                "민주화운동 당시 근거없이 간첩으로 몰려서 고문을 당하고 사망한 운동권 피해자들이 분명히 존재하며 이러한 역사적 사실에도 불구하고 저런 내용의 드라마를 만든 것은 분명히 민주화운동의 가치를 훼손시키는 일이라고 생각합니다. 뿐만 아니라 간첩인 남자주인공이 도망가며, 안기부인 서브 남주인공이 쫓아갈 때 배경음악으로 ‘솔아 푸르른 솔아’ 가 나왔습니다. 이 노래는 민주화운동 당시 학생운동 때 사용되었던 노래이며 민주화운동을 수행하는 사람들의 고통과 승리를 역설하는 노래입니다. 그런 노래를 1980년대 안기부를 연기한 사람과 간첩을 연기하는 사람의 배경음악으로 사용한 것 자체가 용인될 수 없는 행위입니다. 뿐만 아니라 해당 드라마는 ott서비스를 통해 세계 각 국에서 시청할 수 있으며 다수의 외국인에게 민주화운동에 대한 잘못된 역사관을 심어줄 수 있기에 더욱 방영을 강행해서는 안 된다고 생각합니다.\n" +
                "\n" +
                "한국은 엄연한 민주주의 국가이며 이러한 민주주의는 노력없이 이루어진 것이 아닌, 결백한 다수의 고통과 희생을 통해 쟁취한 것입니다. 이로부터 고작 약 30년이 지난 지금, 민주화운동의 가치를 훼손하는 드라마의 방영은 당연히 중지되어야 하며 한국문화의 영향력이 점차 커지고 있는 현 시점에서 방송계 역시 역사왜곡의 심각성에 대해 다시 한번 생각해 봤으면 합니다.\n"));

        petitionRepository.save(new Petition("미접종자 거부와 차별을 멈추게 해주세요.", "보건복지",
                "백신 그만 맞고 싶다"));
    }
}
