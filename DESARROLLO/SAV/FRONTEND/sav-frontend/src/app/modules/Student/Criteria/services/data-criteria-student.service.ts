import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataCriteriaStudentService {

  private idContent: string
  private idSubContent: string

  constructor() {
  }

  getIdContent() {
    return this.idContent
  }

  getIdSubContent() {
    return this.idSubContent
  }

  setIdContent(idContent) {
    this.idContent = idContent
  }

  setIdSubContent(idSubContent) {
    this.idSubContent = idSubContent
  }
}
