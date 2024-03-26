import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { StudentService } from '../services/student.service';
import { Student } from '../model/student.interface';

@Component({
  selector: 'app-student-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './student-form.component.html',
  styleUrl: './student-form.component.css'
})
export default class StudentFormComponent implements OnInit {

  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private studentService = inject(StudentService);
  form?: FormGroup;
  student?: Student;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.studentService.getStudent(parseInt(id))
        .subscribe(student => {
          this.student = student;
          this.form = this.fb.group({
            nombre: [student.nombre, [Validators.required]],
            grado: [student.grado, [Validators.required]],
            grupo: [student.grupo, [Validators.required]]
          });
        })
    } else {
      this.form = this.fb.group({
        nombre: ['', [Validators.required]],
        grado: ['', [Validators.required]],
        grupo: ['', [Validators.required]]
      });
    }
  }

  save() {

    const studentForm = this.form!.value;
    if (this.student) {
      this.studentService.updateStudent(this.student.id, studentForm)
        .subscribe(() => {
          this.router.navigate(['/'])
        });

    } else {
      this.studentService.createStudent(studentForm)
        .subscribe(() => {
          this.router.navigate(['/'])
        });

    }


  }

}
