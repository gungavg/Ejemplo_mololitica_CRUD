import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from '../model/student.interface';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  constructor(private http: HttpClient) { }

  listStudents() {
    return this.http.get<Student[]>('http://localhost:8080/estudiantes');
  }

  getStudent(id: number) {
    return this.http.get<Student>(`http://localhost:8080/estudiantes/${id}`);
  }

  createStudent(student: Student) {
    return this.http.post<Student>('http://localhost:8080/estudiantes/agregar', student);
  }

  updateStudent(id: number, student: Student) {
    return this.http.put<Student>(`http://localhost:8080/estudiantes/editar/${id}`, student);
  }

  deleteStudent(id: number) {
    return this.http.delete(`http://localhost:8080/estudiantes/eliminar/${id}`);
  }
}
