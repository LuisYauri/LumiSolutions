export interface StudentsGroupTeacherModel {
  idEstudiante: number,
  nombre: string
  apaterno: string
  amaterno: string
  username: string
  fechaMatricula: string
}

export interface MatricularStudentsGroupTeacherModel {
  idEstudiante: number,
  nombre: string
  apaterno: string
  amaterno: string
  usuario: string
  contrasenia: string
  marcado:boolean
}
