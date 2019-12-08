import {Component, OnInit} from '@angular/core';
import {StudentsGlobalTeacherModel} from "../../model/students-global-teacher.model";
import {ClassroomGlobalTeacherModel} from "../../../Classroom/model/classroom-global-teacher.model";
import {CreateClassroomGlobalTeacherComponent} from "../../../Classroom/components/Modal/Create/create-classroom-global-teacher.component";
import {CreateStudentsGlobalTeacherComponent} from "../../components/Modal/Create/create-students-global-teacher.component";
import {NzModalService, NzNotificationService} from "ng-zorro-antd";
import {StudentsGlobalTeacherService} from "../../services/students-global-teacher.service";
import {DeleteModalTeacherComponent} from "../../../../../../core/components/Teacher/DeleteModal/delete-modal-teacher.component";

@Component({
  selector: 'app-students-global-teacher',
  templateUrl: './students-global-teacher.component.html',
  styleUrls: ['./students-global-teacher.component.scss']
})
export class StudentsGlobalTeacherComponent implements OnInit {

  varHeader = {
    title: 'Mis Estudiantes',
    icon: 'profile',
    url: ''
  }

  varTitle = 'Banco de estudiantes'
  varLoading = false

  listStudents: StudentsGlobalTeacherModel[]
  tempListStudents: StudentsGlobalTeacherModel[]

  searchValue = '';

  varTitleModal: string
  varAccionModal: number

  constructor(private modalService: NzModalService,
              private notification: NzNotificationService,
              private studentsGlobalTeacherService: StudentsGlobalTeacherService) {
  }

  ngOnInit() {
    this.getListStudents()
  }

  getListStudents() {
    this.varLoading = true
    this.listStudents = [
      {
        "idEstudiante": 1,
        "nombre": "David ",
        "aPaterno": "asxc",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      },
      {
        "idEstudiante": 2,
        "nombre": "Luis",
        "aPaterno": "ertret",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      },
      {
        "idEstudiante": 2,
        "nombre": "Asdffg",
        "aPaterno": "trhg",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "Bxvxcv",
        "aPaterno": "jhjjh",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "Cvcbcvb",
        "aPaterno": "jhhj",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "Drecxkpo",
        "aPaterno": "kjkkj",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "vnpijuE",
        "aPaterno": "hjhjjh",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }
    ]
    this.tempListStudents = this.generateTempListStudents(this.listStudents)
    this.varLoading = false
  }

  reset(): void {
    this.searchValue = '';
    this.listStudents = [...this.tempListStudents]
  }

  search(): void {
    let le = this
    const filterData = this.tempListStudents.filter(function (item: StudentsGlobalTeacherModel) {
      return item.aPaterno.indexOf(le.searchValue) !== -1
    });
    this.listStudents = [...filterData]
  }

  private generateTempListStudents(listStudents: StudentsGlobalTeacherModel[]) {
    return listStudents;
  }

  openAddStudent() {
    this.varTitleModal = "Agregar Estudiante"
    this.varAccionModal = 1
    this.openModalAddEdit(this.varTitleModal, this.varAccionModal)
  }

  openEditStudent(item: any) {
    this.varTitleModal = "Editar Estudiante"
    this.varAccionModal = 2
    this.openModalAddEdit(this.varTitleModal, this.varAccionModal, item)
  }

  openModalAddEdit(title: string, idAccionModal: number, item?: StudentsGlobalTeacherModel) {
    const modal = this.modalService.create({
      nzTitle: title,
      nzContent: CreateStudentsGlobalTeacherComponent,
      nzComponentParams: {
        idAccionModal: idAccionModal,
        item: item
      },
      nzWidth: 500,
      nzMaskClosable: false,
    })
    modal.afterClose.subscribe((response: any) => {
      if (response === undefined) {
        return
      } else if (response.status) {
        this.getListStudents()
      }
    })
  }

  openDeleteStudent(item: StudentsGlobalTeacherModel) {
    const title = 'Eliminar Estudiante'
    const subtitle = '¿Está seguro de eliminar este Estudiante?'
    const description = 'Se eliminarán todos los datos relacionados con este estudiante, no podrá recuperarlo después de realizar la acción.'
    this.openModalDelete(title, subtitle, description,item)
  }

  openModalDelete(title: string, subtitle: string, description: string,item?:StudentsGlobalTeacherModel) {
    const modal = this.modalService.create({
      nzTitle: title,
      nzContent: DeleteModalTeacherComponent,
      nzFooter: null,
      nzComponentParams: {
        subtitle: subtitle,
        description: description
      },
      nzWidth: 500,
      nzMaskClosable: false,
    })
    modal.afterClose.subscribe((response: any) => {
      if (response === undefined) {
        return
      } else if (response.status) {
        this.deleteStudent(item.idEstudiante.toString())
      }
    })
  }

  async deleteStudent(id:string){
    try {
      this.varLoading = true
      await this.studentsGlobalTeacherService.deleteStudents(id).toPromise()
      this.getListStudents()
      this.notification.create(
        'success',
        'Estudiante eliminado correctamente',
        ''
      );
    }catch (e) {
      console.log(e)
      this.varLoading = false
    }
  }



}
