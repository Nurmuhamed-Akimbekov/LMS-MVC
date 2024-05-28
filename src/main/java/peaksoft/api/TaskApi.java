package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.servcie.TaskService;

@Controller
@RequestMapping("tasks/{lessonId}")
@RequiredArgsConstructor
public class TaskApi {
    private final TaskService taskService;

    @GetMapping()
    public String getAllLesson(@PathVariable Long lessonId, Model model) {
        model.addAttribute("allTasks", taskService.getAllTasks(lessonId));
        model.addAttribute("lessonId", lessonId);
        return "/task/task-main";
    }

    @GetMapping("/new")
    public String creatNewLesson(Model model, @PathVariable Long lessonId) {
        model.addAttribute("newTask", new Task());
        model.addAttribute("lessonId", lessonId);
        return "/task/save";
    }

    @PostMapping("/save")
    public String saveLess(@ModelAttribute("newTask") Task task, @PathVariable Long lessonId) {
        taskService.saveTask(lessonId, task);
        return "redirect:/tasks/{lessonId}";
    }

    @GetMapping("/{taskId}/get")
    public String getLesson(@PathVariable Long lessonId, @PathVariable Long taskId, Model model) {
        model.addAttribute("newTask", taskService.getByIdTask(taskId));
        model.addAttribute("taskId", taskId);
        model.addAttribute("lessonId", lessonId);
        return "/task/update";
    }

    @PostMapping("/update/{taskId}")
    public String updateLessonWithId(@PathVariable Long taskId, @ModelAttribute("newTask") Task task) {
       taskService.updateTask(taskId,task);
        return "redirect:/tasks/{lessonId}";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteLesson(@PathVariable Long taskId) {
       taskService.deleteTask(taskId);
        return "redirect:/tasks/{lessonId}";
    }
}
