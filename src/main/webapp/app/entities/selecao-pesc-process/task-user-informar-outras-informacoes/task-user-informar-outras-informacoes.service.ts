import axios from 'axios';
import { TaskUserInformarOutrasInformacoesContext } from './task-user-informar-outras-informacoes.model';

const baseApiUrl = 'api/selecao-pesc-process/task-user-informar-outras-informacoes';

export default class TaskUserInformarOutrasInformacoesService {
  public loadContext(taskId: number): Promise<TaskUserInformarOutrasInformacoesContext> {
    return new Promise<TaskUserInformarOutrasInformacoesContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskUserInformarOutrasInformacoesContext> {
    return new Promise<TaskUserInformarOutrasInformacoesContext>((resolve, reject) => {
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

  public complete(taskUserInformarOutrasInformacoesContext: TaskUserInformarOutrasInformacoesContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskUserInformarOutrasInformacoesContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
