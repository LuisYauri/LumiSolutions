export interface HomeworkGroupTeacherModel {
  cantidadPreguntas: number
  competencia: string
  contenido: string
  fechaInicio: string
  fechaLimite: string
  idCompetencia: number
  idContenido: number
  idTarea: number
  tiempoLimite: string
  titulo: string
}

export interface QuestionsHomeworkGroupTeacherModel {
  marcado: boolean
  idPregunta: number
  descripcion: string
  idCriterio: number
  nombreCriterio: string
  idContenido: number
  nombreContenido: string
  grado: string
}
