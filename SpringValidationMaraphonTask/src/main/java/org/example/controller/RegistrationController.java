package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.ParticipantFormData;
import org.example.pojo.Participant;
import org.example.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class RegistrationController {
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("participant", new ParticipantFormData());
        return "participant_registration";
    }

    @PostMapping("/registration")
    public String createParticipant(
            @ModelAttribute("participant") @Valid ParticipantFormData participantFormData,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors())
            return "participant_registration";
        Participant participant = new Participant(participantFormData.getFirstName(), participantFormData.getLastName(),
                participantFormData.getAge(), participantFormData.isAgree());
        registrationService.addParticipant(participant);
        model.addAttribute("surname", participant.lastName());
        return "redirect:/participants";
    }

    @GetMapping("/participants")
    @ResponseBody
    public String getParticipants() {
        return registrationService.getParticipants().toString();

    }


}

//Создайте проект, который позволяет регистрировать спортсменов на марафон. Зарегистрированы могут быть только
// совершеннолетние спортсмены, указавшие имя, фамилию и дающие согласие на обработку персональных данных.
//1 добавьте зависимость
//https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
//2 создайте бин MethodValidationPostProcessor в конфигурации.
//3 укажите нужные аннотации в контроллерах и, при необходимости, в сервисах.
//4 Для создания чек-бокса (галочки) используйте thymeleaf-код
//<form… >
//    <label>
//        <input type="checkbox" th:checked="${flag}"/> Flag activated
//    </label>
//</form>
