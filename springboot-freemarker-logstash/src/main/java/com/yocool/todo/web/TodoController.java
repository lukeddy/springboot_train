package com.yocool.todo.web;

import com.yocool.todo.model.Todo;
import com.yocool.todo.repositories.TodoRepository;
import com.yocool.todo.vo.TodoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class TodoController {

	private static final Logger log = LoggerFactory.getLogger(TodoController.class);

	private final TodoRepository todoRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	public TodoController(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@RequestMapping("/")
	public String todos(Model model) {
		model.addAttribute("todos", todoRepository.findAll(new PageRequest(0, 50)).getContent());
		return "todos";
	}

	@RequestMapping(value = "/todos/{id}/delete")
	public String deleteTodo(@PathVariable("id") Long id) {
		todoRepository.delete(id);
		return "redirect:/";
	}

	@RequestMapping(value = "/todos/{id}/completed")
	public String deleteTodo(@PathVariable("id") Todo todo) {
		todo.setCompleted(true);
		todoRepository.save(todo);
		return "redirect:/";
	}

	@RequestMapping(value = "/todos", method = RequestMethod.POST)
	public String createTodo(@Valid TodoDto todoDto) {
		todoRepository.save(todoDto.toTodo());
		return "redirect:/";
	}

	@RequestMapping(value = "/todos.csv", method = RequestMethod.GET)
	public void exportTodosCSVSlicing(HttpServletResponse response) {
		final int PAGE_SIZE = 1000;
		response.addHeader("Content-Type", "application/csv");
		response.addHeader("Content-Disposition", "attachment; filename=todos.csv");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			int page = 0;
			Slice<Todo> todoPage;
			do {
				todoPage = todoRepository.findAllBy(new PageRequest(page, PAGE_SIZE));
				for (Todo todo : todoPage) {
					String line = createCSVLine(todo);
					out.write(line);
					out.write("\n");
				}
				entityManager.clear();
				page++;
			} while (todoPage.hasNext());
			out.flush();
		} catch (IOException e) {
			log.info("出错了：" + e.getMessage(), e);
			throw new RuntimeException("导出结果时发生了异常:", e);
		}
	}

	private String createCSVLine(Todo todo) {
		return String.join(",", "" + todo.getId(), "" + todo.getDateCreated(),"" + todo.getDescription(), "" + todo.isCompleted());
	}
}
