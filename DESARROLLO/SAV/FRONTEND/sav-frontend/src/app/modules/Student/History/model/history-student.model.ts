export interface ListHistory {
  lsTareas: TareaHistory[]
  lsExamenes: ExamenHistory[]
}

export interface TareaHistory {
  idTarea: number
  titulo: string
  cantidadPreguntas: number
  fechaRealizada: string
  horaRealizada: string
  contenido: string
  flag?: boolean
}

export interface ExamenHistory {
  idExamen: number
  titulo: string
  cantidadPreguntas: number
  fechaRealizada: string
  horaRealizada: string
  duracion: string
  flag?: boolean
}

export interface ResultStatics {
  idEvaluacion: number
  idEstudiante: number
  nota: string
  totalPreguntas: number
  tipo: string
  lsTiposResultados: TypeResults[]
}

export interface TypeResults {
  tipo: string
  porcentaje: number
  cantidad: number
}

export interface EvaluationHistoryStudent {
  idEvaluacion: number
  titulo: string
  idEstudiante: string
  lsPreguntas: QuestionsEvaluationHistoryStudent[]
}

export interface QuestionsEvaluationHistoryStudent {
  idPregunta: number
  idRecurso: number
  descripcion: string
  urlImagen: string
  tipo: string
  alternativas: string[]
  respuestaEstudiante: string
  respuestaCorrecta: string

}
