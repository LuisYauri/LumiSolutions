export interface Resource {
  idRecurso:number
  nombre:string
  descripcion:string
  tipo:string
  urlRecurso:string
  alumnoCalificacion:number
  promedioCalificacion:number
  lsComentarios: Comment[]
}

export interface Comment {
  idEstudiante:number
  inicialesEstudiante:string
  apellidoPaternoEstudiante:string
  nombreEstudiante:string
  descripcion:string
}

export interface SendComment {
  idRecurso:number
  idEstudiante:number
  descripcion:string
}

export interface SendRate {
  idRecurso:number
  idEstudiante:number
  calificacion:string
}
