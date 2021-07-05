import axios from 'axios';
import { TaskUserInformarDadosPessoaisContext } from './task-user-informar-dados-pessoais.model';

const baseApiUrl = 'api/selecao-pesc-process/task-user-informar-dados-pessoais';

export default class TaskUserInformarDadosPessoaisService {
  public loadContext(taskId: number): Promise<TaskUserInformarDadosPessoaisContext> {
    return new Promise<TaskUserInformarDadosPessoaisContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskUserInformarDadosPessoaisContext> {
    return new Promise<TaskUserInformarDadosPessoaisContext>((resolve, reject) => {
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

  public complete(taskUserInformarDadosPessoaisContext: TaskUserInformarDadosPessoaisContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskUserInformarDadosPessoaisContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
