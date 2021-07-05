/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import SelecaoPescService from '@/entities/selecao-pesc/selecao-pesc.service';
import { SelecaoPesc } from '@/shared/model/selecao-pesc.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('SelecaoPesc Service', () => {
    let service: SelecaoPescService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new SelecaoPescService();
      currentDate = new Date();
      elemDefault = new SelecaoPesc(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            dataNascimento: dayjs(currentDate).format(DATE_FORMAT),
            formacaoInicio: dayjs(currentDate).format(DATE_FORMAT),
            formacaoTermino: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of SelecaoPesc', async () => {
        const returnedFromService = Object.assign(
          {
            nomeCompleto: 'BBBBBB',
            emailPrincipal: 'BBBBBB',
            nacionalidade: 'BBBBBB',
            documentoCpfPassaporte: 'BBBBBB',
            dataNascimento: dayjs(currentDate).format(DATE_FORMAT),
            cidadeNascimento: 'BBBBBB',
            temExperienciaProfissional: 'BBBBBB',
            temDocencia: 'BBBBBB',
            formacaoInstituicaoNome: 'BBBBBB',
            formacaoCursoSuperior: 'BBBBBB',
            formacaoInicio: dayjs(currentDate).format(DATE_FORMAT),
            formacaoTermino: dayjs(currentDate).format(DATE_FORMAT),
            empresaNome: 'BBBBBB',
            empresaUrlSite: 'BBBBBB',
            empresaFuncao: 'BBBBBB',
            docenciaInstituicaoNome: 'BBBBBB',
            docenciaInstituicaoPais: 'BBBBBB',
            docenciaNomeDisciplina: 'BBBBBB',
            proficienciaInglesTipoTeste: 'BBBBBB',
            proficienciaInglesNota: 1,
            mestradoDoutorado: 'BBBBBB',
            linhaAreaInteresse: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            dataNascimento: currentDate,
            formacaoInicio: currentDate,
            formacaoTermino: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of SelecaoPesc', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
