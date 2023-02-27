package com.controller;

import com.model.dto.FacilityDto;
import com.model.faccility.Facility;
import com.service.impl.FacilityService;
import com.service.impl.FacilityTypeService;
import com.service.impl.RentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private FacilityTypeService facilityTypeService;
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/")
    public String showList(@RequestParam(defaultValue = "", required = false) String name,
                           @RequestParam(defaultValue = "", required = false) String facilityTypeId,
                           @PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
        Page<Facility> facilityPage = facilityService.findAll(name, facilityTypeId, pageable);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute FacilityDto facilityDto, Model model, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityDto",new FacilityDto());
            return "/facility/create";
        }
        Facility facility =new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.save(facility);
        redirect.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/facility/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Facility facility = facilityService.findById(id);
        if (facility == null) {
            model.addAttribute("mess", "dịch vụ không tồn tại");
            return "/facility/list";
        }
        model.addAttribute("facility", facility);
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/saveEdit")
    public String saveEdit(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/facility/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id,RedirectAttributes redirectAttributes) {
        facilityService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/facility/";
    }
}
