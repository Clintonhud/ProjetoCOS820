import axios from 'axios';
import { TaskUserRealizarCandidaturaContext } from './task-user-realizar-candidatura.model';

const baseApiUrl = 'api/selecao-pesc-process/task-user-realizar-candidatura';

export default class TaskUserRealizarCandidaturaService {
  public loadContext(taskId: number): Promise<TaskUserRealizarCandidaturaContext> {
    return new Promise<TaskUserRealizarCandidaturaContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskUserRealizarCandidaturaContext> {
    return new Promise<TaskUserRealizarCandidaturaContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskUserRealizarCandidaturaContext: TaskUserRealizarCandidaturaContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskUserRealizarCandidaturaContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
