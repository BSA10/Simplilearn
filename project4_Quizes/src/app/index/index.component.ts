import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models';
import { QuizComponent } from '../quiz/quiz.component';
import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css'],
  providers: [QuizService]
})
export class IndexComponent implements OnInit {

  quizName:string;

  constructor(private quizService:QuizService) {
    
  }

  ngOnInit() {
  }
   
  
  test(quizName:string){
    
    // console.log(quizName);
    this.quizService.setName(quizName);
    
  }
  

}
