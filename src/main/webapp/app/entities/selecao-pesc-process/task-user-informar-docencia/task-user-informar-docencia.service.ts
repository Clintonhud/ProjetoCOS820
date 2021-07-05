import axios from 'axios';
import { TaskUserInformarDocenciaContext } from './task-user-informar-docencia.model';

const baseApiUrl = 'api/selecao-pesc-process/task-user-informar-docencia';

export default class TaskUserInformarDocenciaService {
  public loadContext(taskId: number): Promise<TaskUserInformarDocenciaContext> {
    return new Promise<TaskUserInformarDocenciaContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskUserInformarDocenciaContext> {
    return new Promise<TaskUserInformarDocenciaContext>((resolve, reject) => {
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

  public complete(taskUserInformarDocenciaContext: TaskUserInformarDocenciaContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskUserInformarDocenciaContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
