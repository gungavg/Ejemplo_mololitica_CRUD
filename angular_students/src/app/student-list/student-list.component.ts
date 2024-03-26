import { Component, OnInit, inject } from '@angular/core';
import { StudentService } from '../services/student.service';
import { RouterModule } from '@angular/router';
import { Student } from '../model/student.interface';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export default class StudentListComponent implements OnInit {
  private studentService = inject(StudentService);
  students: Student[] = [];
  ngOnInit(): void {
    this.loadAll();
  }
  loadAll() {
    this.studentService.listStudents()
      .subscribe((students) => {
        this.students = students;
      });
  }

  delete(student: Student) {
    this.studentService.deleteStudent(student.id)
      .subscribe(() => {
        this.loadAll();
      });
  }


}
