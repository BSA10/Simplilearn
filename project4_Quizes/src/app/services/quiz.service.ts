import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class QuizService {

  constructor(private http: HttpClient) { }

  private name:string;

  get(url: string) {
    return this.http.get(url);
  }

  setName(name:string){
    this.name = name;
  }
  getName():string{
    return this.name;
  }

  getAll() {
    return [
      { id: 'data/java.json', name: 'Java' },
      { id: 'data/javascript.json', name: 'JavaScript' },
    ];
  }

}
