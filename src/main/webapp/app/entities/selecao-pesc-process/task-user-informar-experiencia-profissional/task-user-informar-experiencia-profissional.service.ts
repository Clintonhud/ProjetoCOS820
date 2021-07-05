import axios from 'axios';
import { TaskUserInformarExperienciaProfissionalContext } from './task-user-informar-experiencia-profissional.model';

const baseApiUrl = 'api/selecao-pesc-process/task-user-informar-experiencia-profissional';

export default class TaskUserInformarExperienciaProfissionalService {
  public loadContext(taskId: number): Promise<TaskUserInformarExperienciaProfissionalContext> {
    return new Promise<TaskUserInformarExperienciaProfissionalContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskUserInformarExperienciaProfissionalContext> {
    return new Promise<TaskUserInformarExperienciaProfissionalContext>((resolve, reject) => {
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

  public complete(taskUserInformarExperienciaProfissionalContext: TaskUserInformarExperienciaProfissionalContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskUserInformarExperienciaProfissionalContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
