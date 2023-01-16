import { Injectable } from '@angular/core';
import { CommonService } from './common.service';
import { Course } from '../models/Course';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConnectedOverlayPositionChange } from '@angular/cdk/overlay';

@Injectable({
  providedIn: 'root'
})
export class CourseService extends CommonService<Course> {

  protected baseEnpoint = `${environment.API_URL}/courses`;
  public formData = new FormData();
  constructor(http: HttpClient) {
    super(http);
  }

  public createCourse(course: Course): Observable<Course> {
    const formData = this.buildForm(course);
    console.log("zzzzz",formData.get)
    return this.http.post<Course>(this.baseEnpoint + "/create-course", formData);
  }

  public editWithImage(course: Course): Observable<Course> {
    const formData = this.buildForm(course);
    return this.http.put<Course>(`${this.baseEnpoint}/${course.id}/update/`, formData);
  }

  public deleteCourse(course: Course): Observable<Course> {
    const formData = this.buildForm(course);
    return this.http.put<Course>(`${this.baseEnpoint}/delete-course/${course.id}`, formData);
  }




  public buildForm(course: Course){
    const formData = new FormData();
    formData.append("name", course.name);
    formData.append("description", course.description);
    formData.append("createdAt", "")
    formData.append("updatedAt", "");
    formData.append("courseStudents", "");
    formData.append("students", "")
    formData.append("exams", "")

    return formData;
  }

}
