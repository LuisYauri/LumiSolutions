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
}

export interface ExamenHistory {
  idExamen: number
  titulo: string
  cantidadPreguntas: number
  fechaRealizada: string
  horaRealizada: string
  duracion: string
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
