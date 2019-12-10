export interface ExamnStudent {
  idExamen: number
  titulo: string
  cantidadPreguntas: string
  fechaInico: string
  horaInicio: string
  duracion:number
  flag?: boolean
}

export interface QuestionsExamnStudent {
  idExamen: number
  titulo: string
  duracion:number
  lsPreguntas: QuestionExamnStudent[]
}

export interface QuestionExamnStudent {
  idPregunta: number
  idRecurso: number
  descripcion: string
  urlImagen: string
  tipo: string
  alternativas: string[]
}

export interface SendAnswersExamenStudent {
  idExamen: number
  titulo: string
  duracion:number
  idEstudiante: number
  lsPreguntas: QuestionAExamenStudent[]
}

export interface QuestionAExamenStudent {
  idPregunta: number
  descripcion: string
  urlImagen: string
  tipo: string
  alternativas: string[]
  respuestaEstudiante: string
}

export interface ResultsExamenStudent  {
  nota: string
  totalPreguntas: number
  tipo: string
  lsTiposResultados: ResultExamenStudent []
}

export interface ResultExamenStudent {
  tipo: string
  porcentaje: number
  cantidad: number
}
