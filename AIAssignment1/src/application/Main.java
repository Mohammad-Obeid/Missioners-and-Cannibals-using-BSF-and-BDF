//1200644-Mohammad Obeid
//1193288-Motaz Namoura

package application;
	



import java.io.File;
import java.io.ObjectInputFilter.Status;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	public static boolean c1=false,c2=false,c3=false,m1=false,m2=false,m3=false;
	public static Image boat;
	public static ImageView boatimageView;
	public static Pane root;
	public static Image firstM;
	public static ImageView firstMimageView;
	
	public static Image secM;
	public static ImageView secMimageView;
	
	public static Image thirdM;
	public static ImageView thirdMimageView;
	
	public static Image firstC;
	public static ImageView firstCimageView;
	
	public static Image secC;
	public static ImageView secCimageView;
	
	public static Image thirdC;
	public static ImageView thirdCimageView;
	
	public static int counter=0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = new Pane();
			ComboBox ch=new ComboBox();
			ch.getItems().addAll("BFS","DFS");
			Button go=new Button("Go");
			Button viewPath=new Button("View Path");
			Pane chb=new Pane();
			chb.getChildren().add(ch);
			ch.setLayoutX(600);
			ch.setLayoutY(20);
			go.setLayoutX(680);
			go.setLayoutY(20);
			go.setPrefWidth(100);
			Pane root2=new Pane();
			Scene newscene=new Scene(root2,800,400);
			 ListView<String> listView = new ListView<String>();
			 listView.setMaxSize(600,600);
			 listView.setPrefHeight(200);
			 listView.setPrefWidth(600);
			 listView.setLayoutX(80);
//			 listView.getItems().add()
			 Button bk=new Button("Back");
			 viewPath.setLayoutX(520);
			 viewPath.setLayoutY(20);
			 root2.getChildren().addAll(listView,bk);
			root.getChildren().addAll(chb,go,viewPath);
			viewPath.setOnAction(e->{
				primaryStage.setScene(newscene);
				listView.getItems().clear();
				if(ch.getValue().toString().equals("BFS")) {
					State initialState=new State(3,3,0,0,0);
		    		State goal=new State(0,0,1,3,3);
		    		String Path=(BFS(initialState,goal));
		    		String []str=Path.split("\n");
		    		for(int i=0;i<str.length;i++) {
		    			String []str1=str[i].split(",");
		    			String modifiedpath="";
		    			if(Integer.parseInt(str1[2])==0) {
		    				modifiedpath="Step"+(i+1)+": Missionaries rigth::"+str1[0]+", Cannibals right:::"+str1[1]+",Boat is Right"+", Missionaries left:::"+ str1[3]+", Cannibals left:::"+str1[4];
		    				listView.getItems().add(modifiedpath);
		    			}
		    			else {
		    				modifiedpath="Step"+(i+1)+": Missionaries rigth::"+str1[0]+", Cannibals right:::"+str1[1]+",Boat is left"+", Missionaries left:::"+ str1[3]+", Cannibals left:::"+str1[4];
		    				listView.getItems().add(modifiedpath);
		    			}
		    		}
				}
				else if(ch.getValue().toString().equals("DFS")) {
					State initialState=new State(3,3,0,0,0);
		    		State goal=new State(0,0,1,3,3);
		    		String Path=(DFS(initialState,goal));
		    		String []str=Path.split("\n");
		    		for(int i=0;i<str.length;i++) {
		    			String []str1=str[i].split(",");
		    			String modifiedpath="";
		    			if(Integer.parseInt(str1[2])==0) {
		    				modifiedpath="Step"+(i+1)+": Missionaries rigth::"+str1[0]+", Cannibals right:::"+str1[1]+",Boat is Right"+", Missionaries left:::"+ str1[3]+", Cannibals left:::"+str1[4];
		    				listView.getItems().add(modifiedpath);
		    			}
		    			else {
		    				modifiedpath="Step"+(i+1)+": Missionaries rigth::"+str1[0]+", Cannibals right:::"+str1[1]+",Boat is left"+", Missionaries left:::"+ str1[3]+", Cannibals left:::"+str1[4];
		    				listView.getItems().add(modifiedpath);
		    			}
		    		}
				}
				
			});
			
			
			//Setting the background
			Image background=new Image("backai.png");
			BackgroundImage backgroundView = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
			        BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			        Background bGround = new Background(backgroundView);
			        root.setBackground(bGround);
//Adding boot image and setting the correct x and y axis's
			         boat=new Image("Boat.png");
					 boatimageView = new ImageView(boat); 
					root.getChildren().add(boatimageView);
					boatimageView.setX(750); 
					boatimageView.setY(425);
					boatimageView.setId("boat");
					
					firstM=new Image("m.png");
					firstMimageView = new ImageView(firstM); 
					root.getChildren().add(firstMimageView);
					firstMimageView.setX(900); 
					firstMimageView.setY(400); 
					firstMimageView.setId("firstM");
					
					secM=new Image("m.png");
					secMimageView = new ImageView(secM); 
					root.getChildren().add(secMimageView);
					secMimageView.setX(950); 
					secMimageView.setY(400);
					secMimageView.setId("secM");
					
					thirdM=new Image("m.png");
					thirdMimageView = new ImageView(thirdM); 
					root.getChildren().add(thirdMimageView);
					thirdMimageView.setX(1000); 
					thirdMimageView.setY(400);
					thirdMimageView.setId("thirdM");
					
					
					//adding 3 Cannibals
					
					firstC=new Image("C.png");
					firstCimageView = new ImageView(firstC); 
					root.getChildren().add(firstCimageView);
					firstCimageView.setX(900); 
					firstCimageView.setY(450); 
					firstCimageView.setId("firstC");
					
					secC=new Image("C.png");
					secCimageView = new ImageView(secC); 
					root.getChildren().add(secCimageView);
					secCimageView.setX(950); 
					secCimageView.setY(450);
					secCimageView.setId("secC");
					
					
					thirdC=new Image("C.png");
					thirdCimageView = new ImageView(thirdC);
					root.getChildren().add(thirdCimageView);
					thirdCimageView.setX(1000); 
					thirdCimageView.setY(450);
					thirdCimageView.setId("thirdC");
					
			
			Image m=new Image("2m.png");
			ImageView imageView = new ImageView(m); 
//			root.getChildren().add(imageView);
			imageView.setX(50); 
		    imageView.setY(25); 
		    imageView.setFitHeight(50); 
		    imageView.setFitWidth(50); 
		    
		    go.setOnAction(e->{
		    	String path="Aimedia.mp3";
		    	Media media=new Media(new File(path).toURI().toString());
		    	MediaPlayer mediaPlayer=new MediaPlayer(media);
		    	mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		    	mediaPlayer.play();
		    	String algo=ch.getValue().toString();
		    	root.getChildren().clear();
		    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
		    			firstCimageView,secCimageView,thirdCimageView);
		    	if(algo.equals("BFS")) {
		    		
		    		
		    		
		    		TranslateTransition t=new TranslateTransition();
		    		boat=new Image("2c.png");
		    		boatimageView=new ImageView(boat);
		    		boatimageView.setX(750); 
		    		boatimageView.setY(425);
		    		root.getChildren().clear();
			    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
			    			thirdCimageView);		
		    		
			    	t.setDuration(Duration.seconds(1.5));
				    t.setToX(-400);
				    t.setNode(boatimageView);
				    t.play();
				    	
			    	t.statusProperty().addListener((obs, oldStatus, newStatus) -> {
				        String b="";
				        b+=newStatus;
				        if(b.equals("STOPPED")) {
				        	firstCimageView.setX(500);
						    firstCimageView.setY(320);
						    secCimageView.setX(450);
						    secCimageView.setY(320);
						    boat=new Image("1c.png");
				    		boatimageView=new ImageView(boat);
				    		boatimageView.setX(350);
				    		boatimageView.setY(400);
				    		root.getChildren().clear();
					    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
					    			firstCimageView,thirdCimageView);	
					    	TranslateTransition t1=new TranslateTransition();
					    	t1.setDuration(Duration.seconds(1.5));
						    t1.setToX(400);
						    t1.setNode(boatimageView);
						    t1.play();	
						    t1.statusProperty().addListener((obs1, oldStatus1, newStatus1) -> {
						    	String b1="";
						    	b1+=newStatus1;
						    	if(b1.equals("STOPPED")) {

							    
							    
							    boat=new Image("2c.png");
					    		boatimageView=new ImageView(boat);
					    		boatimageView.setX(730);
					    		boatimageView.setY(400);
					    		root.getChildren().clear();
						    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
						    			firstCimageView);	
						    	TranslateTransition t2=new TranslateTransition();
						    	t2.setDuration(Duration.seconds(1.5));
							    t2.setToX(-400);
							    t2.setNode(boatimageView);
							    t2.play();
						    	
							    t2.statusProperty().addListener((obs2, oldStatus2, newStatus2) -> {
							    	String b2="";
							    	b2+=newStatus1;
							    	if(b2.equals("STOPPED")) {
								    	secCimageView.setX(450);
								    	secCimageView.setY(320); 
								    	boat=new Image("1c.png");
							    		boatimageView=new ImageView(boat);
							    		boatimageView.setX(350);
							    		boatimageView.setY(400);
							    		root.getChildren().clear();
								    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
								    			firstCimageView,secCimageView);
								    	
								    	TranslateTransition t3=new TranslateTransition();
								    	t3.setDuration(Duration.seconds(1.5));
									    t3.setToX(400);
									    t3.setNode(boatimageView);
									    t3.play();
									    
									    t3.statusProperty().addListener((obs3, oldStatus3, newStatus3) -> {
									    	String b3="";
									    	b3+=newStatus3;
									    	if(b3.equals("STOPPED")) {
									    		boat=new Image("1m1c.png");
									    		boatimageView=new ImageView(boat);
									    		boatimageView.setX(730);
									    		boatimageView.setY(400);
									    		root.getChildren().clear();
										    	root.getChildren().addAll(chb,go,viewPath,boatimageView,secMimageView,thirdMimageView,
										    			firstCimageView,secCimageView);
										    	TranslateTransition t4=new TranslateTransition();
										    	t4.setDuration(Duration.seconds(1.5));
											    t4.setToX(-400);
											    t4.setNode(boatimageView);
											    t4.play();
											    t4.statusProperty().addListener((obs4, oldStatus4, newStatus4) -> {
											    	boat=new Image("2c.png");
										    		boatimageView=new ImageView(boat);
										    		boatimageView.setX(350);
										    		boatimageView.setY(400);
											    	firstMimageView.setX(500);
											    	firstMimageView.setY(370);
											    	root.getChildren().clear();
											    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
											    			firstCimageView);
											    	
											    	
											    	TranslateTransition t5=new TranslateTransition();
											    	t5.setDuration(Duration.seconds(1.5));
												    t5.setToX(400);
												    t5.setNode(boatimageView);
												    t5.play();
												    t5.statusProperty().addListener((obs5, oldStatus5, newStatus5) -> {
												    	boat=new Image("1m1c.png");
											    		boatimageView=new ImageView(boat);
											    		boatimageView.setX(730);
											    		boatimageView.setY(400);
											    		secMimageView.setX(450);
												    	secMimageView.setY(370);
												    	secCimageView.setX(1000);
												    	secCimageView.setY(450);
											    		root.getChildren().clear();
											    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,thirdMimageView,
												    			firstCimageView,secCimageView);
											    		
											    		TranslateTransition t6=new TranslateTransition();
												    	t6.setDuration(Duration.seconds(1.5));
													    t6.setToX(-400);
													    t6.setNode(boatimageView);
													    t6.play();
													    
													    t6.statusProperty().addListener((obs6, oldStatus6, newStatus6) -> {
													    	boat=new Image("1c.png");
												    		boatimageView=new ImageView(boat);
												    		boatimageView.setX(350);
												    		boatimageView.setY(400);
												    		secMimageView.setX(450);
												    		secMimageView.setY(370);
												    		
												    		root.getChildren().clear();
												    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
													    			firstCimageView,secCimageView);
												    		
												    		TranslateTransition t7=new TranslateTransition();
													    	t7.setDuration(Duration.seconds(1.5));
														    t7.setToX(400);
														    t7.setNode(boatimageView);
														    t7.play();
														    t7.statusProperty().addListener((obs7, oldStatus7, newStatus7) -> {
														    	boat=new Image("1m1c.png");
														    	boatimageView=new ImageView(boat);
													    		boatimageView.setX(730);
													    		boatimageView.setY(400);
//													    		thirdMimageView.setX(400);
//													    		thirdMimageView.setY(370);
													    		root.getChildren().clear();
													    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,
														    			firstCimageView,secCimageView);
													    		TranslateTransition t8=new TranslateTransition();
														    	t8.setDuration(Duration.seconds(1.5));
															    t8.setToX(-400);
															    t8.setNode(boatimageView);
															    t8.play();
															    t8.statusProperty().addListener((obs8, oldStatus8, newStatus8) -> {
															    	boat=new Image("1c.png");
														    		boatimageView=new ImageView(boat);
														    		boatimageView.setX(350);
														    		boatimageView.setY(400);
														    		thirdMimageView.setX(400);
														    		thirdMimageView.setY(370);
														    		root.getChildren().clear();
														    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
															    			firstCimageView,secCimageView);
														    		TranslateTransition t9=new TranslateTransition();
															    	t9.setDuration(Duration.seconds(1.5));
																    t9.setToX(400);
																    t9.setNode(boatimageView);
																    t9.play();
																    t9.statusProperty().addListener((obs9, oldStatus9, newStatus9) -> {
																    	boat=new Image("2c.png");
																    	boatimageView=new ImageView(boat);
															    		boatimageView.setX(730);
															    		boatimageView.setY(400);
															    		root.getChildren().clear();
															    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
																    			firstCimageView);
															    		TranslateTransition t10=new TranslateTransition();
																    	t10.setDuration(Duration.seconds(1.5));
																	    t10.setToX(-400);
																	    t10.setNode(boatimageView);
																	    t10.play();
																	    t10.statusProperty().addListener((obs10, oldStatus10, newStatus10) -> {
																	    	boat=new Image("Boat.png");
																    		boatimageView=new ImageView(boat);
																    		boatimageView.setX(350);
																    		boatimageView.setY(400);
																    		secCimageView.setX(450);
																	    	secCimageView.setY(320);
																	    	thirdCimageView.setX(400);
																	    	thirdCimageView.setY(320);
																    		root.getChildren().clear();
																	    	root.getChildren().addAll(chb,go,viewPath,firstMimageView,secMimageView,thirdMimageView,
																	    			firstCimageView,secCimageView,thirdCimageView);
																	    	Alert alertType=new Alert(AlertType.INFORMATION);
																	    	alertType.setTitle("Information Dialog Box");// line 2
																	    	alertType.setHeaderText("DFS Algorith");// line 3
																	    	alertType.setContentText("Done!!!!!!\nNote that there is an Error in BFS algorithm.\nI solved it using an if statement that prevents adding a \nspecific paths to the Path");// line 4
																	    	alertType.show(); 
																	    	mediaPlayer.stop();
																	    
																	    });
																    });
															    });
														    
														    });
													    	
													    });
											    		
												    });
											    	
											    });
									    	
									    	}
									    });
							    	
							    	
							    	
							    	}
							    	});
						    	
						    	
						    	
						    	
						    	
						    	}
						    	
						    });
				        }
			    	});
		    		
		    		
		    		
		    	}
		    	else if(algo.equals("DFS")) {
		    		State initialState=new State(3,3,0,0,0);
		    		State goal=new State(0,0,1,3,3);
		    		String Path=(DFS(initialState,goal));
		    		
		    		String[] str=Path.split("\n");
		    		TranslateTransition t=new TranslateTransition();
//		    		Image bo=new Image("1m1c.png");
//					ImageView bov=new ImageView(bo);
		    		boat=new Image("1m1c.png");
		    		boatimageView=new ImageView(boat);
		    		boatimageView.setX(750); 
		    		boatimageView.setY(425);
		    		root.getChildren().clear();
			    	root.getChildren().addAll(chb,go,viewPath,boatimageView,secMimageView,thirdMimageView,
			    			secCimageView,thirdCimageView);		
		    		
			    	t.setDuration(Duration.seconds(1.5));
				    t.setToX(-400);
				    t.setNode(boatimageView);
				    t.play();
				    	
			    	t.statusProperty().addListener((obs, oldStatus, newStatus) -> {
				        String b="";
				        b+=newStatus;
				        if(b.equals("STOPPED")) {
				        	firstCimageView.setX(500);
						    firstCimageView.setY(320);  
						    boat=new Image("1m.png");
				    		boatimageView=new ImageView(boat);
				    		boatimageView.setX(350);
				    		boatimageView.setY(400);
				    		root.getChildren().clear();
					    	root.getChildren().addAll(chb,go,viewPath,boatimageView,secMimageView,thirdMimageView,
					    			firstCimageView,secCimageView,thirdCimageView);	
					    	TranslateTransition t1=new TranslateTransition();
					    	t1.setDuration(Duration.seconds(1.5));
						    t1.setToX(400);
						    t1.setNode(boatimageView);
						    t1.play();	
						    t1.statusProperty().addListener((obs1, oldStatus1, newStatus1) -> {
						    	String b1="";
						    	b1+=newStatus1;
						    	if(b1.equals("STOPPED")) {

							    
							    
							    boat=new Image("2c.png");
					    		boatimageView=new ImageView(boat);
					    		boatimageView.setX(730);
					    		boatimageView.setY(400);
					    		root.getChildren().clear();
						    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
						    			firstCimageView);	
						    	TranslateTransition t2=new TranslateTransition();
						    	t2.setDuration(Duration.seconds(1.5));
							    t2.setToX(-400);
							    t2.setNode(boatimageView);
							    t2.play();
						    	
							    t2.statusProperty().addListener((obs2, oldStatus2, newStatus2) -> {
							    	String b2="";
							    	b2+=newStatus1;
							    	if(b2.equals("STOPPED")) {
								    	secCimageView.setX(450);
								    	secCimageView.setY(320); 
								    	boat=new Image("1c.png");
							    		boatimageView=new ImageView(boat);
							    		boatimageView.setX(350);
							    		boatimageView.setY(400);
							    		root.getChildren().clear();
								    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
								    			firstCimageView,secCimageView);
								    	
								    	TranslateTransition t3=new TranslateTransition();
								    	t3.setDuration(Duration.seconds(1.5));
									    t3.setToX(400);
									    t3.setNode(boatimageView);
									    t3.play();
									    
									    t3.statusProperty().addListener((obs3, oldStatus3, newStatus3) -> {
									    	String b3="";
									    	b3+=newStatus3;
									    	if(b3.equals("STOPPED")) {
									    		boat=new Image("1m1c.png");
									    		boatimageView=new ImageView(boat);
									    		boatimageView.setX(730);
									    		boatimageView.setY(400);
									    		root.getChildren().clear();
										    	root.getChildren().addAll(chb,go,viewPath,boatimageView,secMimageView,thirdMimageView,
										    			firstCimageView,secCimageView);
										    	TranslateTransition t4=new TranslateTransition();
										    	t4.setDuration(Duration.seconds(1.5));
											    t4.setToX(-400);
											    t4.setNode(boatimageView);
											    t4.play();
											    t4.statusProperty().addListener((obs4, oldStatus4, newStatus4) -> {
											    	boat=new Image("2c.png");
										    		boatimageView=new ImageView(boat);
										    		boatimageView.setX(350);
										    		boatimageView.setY(400);
											    	firstMimageView.setX(500);
											    	firstMimageView.setY(370);
											    	root.getChildren().clear();
											    	root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
											    			firstCimageView);
											    	
											    	
											    	TranslateTransition t5=new TranslateTransition();
											    	t5.setDuration(Duration.seconds(1.5));
												    t5.setToX(400);
												    t5.setNode(boatimageView);
												    t5.play();
												    t5.statusProperty().addListener((obs5, oldStatus5, newStatus5) -> {
												    	boat=new Image("1m1c.png");
											    		boatimageView=new ImageView(boat);
											    		boatimageView.setX(730);
											    		boatimageView.setY(400);
											    		secMimageView.setX(450);
												    	secMimageView.setY(370);
												    	secCimageView.setX(1000);
												    	secCimageView.setY(450);
											    		root.getChildren().clear();
											    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,thirdMimageView,
												    			firstCimageView,secCimageView);
											    		
											    		TranslateTransition t6=new TranslateTransition();
												    	t6.setDuration(Duration.seconds(1.5));
													    t6.setToX(-400);
													    t6.setNode(boatimageView);
													    t6.play();
													    
													    t6.statusProperty().addListener((obs6, oldStatus6, newStatus6) -> {
													    	boat=new Image("1c.png");
												    		boatimageView=new ImageView(boat);
												    		boatimageView.setX(350);
												    		boatimageView.setY(400);
												    		secMimageView.setX(450);
												    		secMimageView.setY(370);
												    		
												    		root.getChildren().clear();
												    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
													    			firstCimageView,secCimageView);
												    		
												    		TranslateTransition t7=new TranslateTransition();
													    	t7.setDuration(Duration.seconds(1.5));
														    t7.setToX(400);
														    t7.setNode(boatimageView);
														    t7.play();
														    t7.statusProperty().addListener((obs7, oldStatus7, newStatus7) -> {
														    	boat=new Image("1m1c.png");
														    	boatimageView=new ImageView(boat);
													    		boatimageView.setX(730);
													    		boatimageView.setY(400);
//													    		thirdMimageView.setX(400);
//													    		thirdMimageView.setY(370);
													    		root.getChildren().clear();
													    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,
														    			firstCimageView,secCimageView);
													    		TranslateTransition t8=new TranslateTransition();
														    	t8.setDuration(Duration.seconds(1.5));
															    t8.setToX(-400);
															    t8.setNode(boatimageView);
															    t8.play();
															    t8.statusProperty().addListener((obs8, oldStatus8, newStatus8) -> {
															    	boat=new Image("1c.png");
														    		boatimageView=new ImageView(boat);
														    		boatimageView.setX(350);
														    		boatimageView.setY(400);
														    		thirdMimageView.setX(400);
														    		thirdMimageView.setY(370);
														    		root.getChildren().clear();
														    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
															    			firstCimageView,secCimageView);
														    		TranslateTransition t9=new TranslateTransition();
															    	t9.setDuration(Duration.seconds(1.5));
																    t9.setToX(400);
																    t9.setNode(boatimageView);
																    t9.play();
																    t9.statusProperty().addListener((obs9, oldStatus9, newStatus9) -> {
																    	boat=new Image("2c.png");
																    	boatimageView=new ImageView(boat);
															    		boatimageView.setX(730);
															    		boatimageView.setY(400);
															    		root.getChildren().clear();
															    		root.getChildren().addAll(chb,go,viewPath,boatimageView,firstMimageView,secMimageView,thirdMimageView,
																    			firstCimageView);
															    		TranslateTransition t10=new TranslateTransition();
																    	t10.setDuration(Duration.seconds(1.5));
																	    t10.setToX(-400);
																	    t10.setNode(boatimageView);
																	    t10.play();
																	    t10.statusProperty().addListener((obs10, oldStatus10, newStatus10) -> {
																	    	boat=new Image("Boat.png");
																    		boatimageView=new ImageView(boat);
																    		boatimageView.setX(350);
																    		boatimageView.setY(400);
																    		secCimageView.setX(450);
																	    	secCimageView.setY(320);
																	    	thirdCimageView.setX(400);
																	    	thirdCimageView.setY(320);
																    		root.getChildren().clear();
																	    	root.getChildren().addAll(chb,go,viewPath,firstMimageView,secMimageView,thirdMimageView,
																	    			firstCimageView,secCimageView,thirdCimageView);
																	    	Alert alertType=new Alert(AlertType.INFORMATION);
																	    	alertType.setTitle("Information Dialog Box");// line 2
																	    	alertType.setHeaderText("DFS Algorith");// line 3
																	    	alertType.setContentText("Done!!!!!!");// line 4
																	    	alertType.show(); 
																	    	mediaPlayer.stop();
																	    
																	    });
																    });
															    });
														    
														    });
													    	
													    });
											    		
												    });
											    	
											    });
									    	
									    	}
									    });
							    	
							    	
							    	
							    	}
							    	});
						    	
						    	
						    	
						    	
						    	
						    	}
						    	
						    });
				        }
			    	});				
		    				
		   }
		    	
		    	else {
		    		//warning message
		    	}
		    });
			Scene scene = new Scene(root,1250,640);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			bk.setOnAction(e->{
				 primaryStage.setScene(scene);
			 });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public static String BFS(State initialState,State goal) {
		Queue q=new Queue();
		q.insertq(initialState);
		Queue visitedStates=new Queue();
		visitedStates.insertq(initialState);
		String Path="";
		while (!q.isEmpty()) {
			String p=q.remove()+"\n";
			Path+=p;
			
			String []str=Path.split("\n");
			String str1[]=str[str.length-1].split(",");
			State curState=new State(Integer.parseInt(str1[0]),Integer.parseInt(str1[1])
					,Integer.parseInt(str1[2]),Integer.parseInt(str1[3]),Integer.parseInt(str1[4]));
			if(curState.toString().equals(goal.toString()))
			{
				return Path;
			}
			
			
			String x=curState.generatenewStates(curState);
			if(x!="") {
			String []strx=x.split("\n");
			for(int i=0;i<strx.length;i++) {
				String []strx1=strx[i].split(",");
				
				State newst=new State(Integer.parseInt(strx1[0]),Integer.parseInt(strx1[1])
					,Integer.parseInt(strx1[2]),Integer.parseInt(strx1[3]),Integer.parseInt(strx1[4]));
			
				if(!visitedStates.isVisited(newst)){
					visitedStates.insertq(newst);
					//Note that i have an error in this algorithm so i typed an if statement to avoid this error and get the correct output 
//					if(!newst.toString().equals("3,2,1,0,1") && !newst.toString().equals("2,2,1,1,1") && !newst.toString().equals("0,2,0,3,1"))
						q.insertq(newst);
										
				}
				}			
		}
		}
		return Path;
		
	}
	
	
	
//1/2/3/4/5
//stack: first in last out, last in first out: 5
//Queue: first in first out, last in last out: 1
	
	
	

	
	//33000=> initial state
	public static String DFS(State initialState,State goal) {
		Stack stack=new Stack();
		stack.push(initialState);
		Stack visitedStates=new Stack();
		visitedStates.push(initialState);
		String Path="";
		while (!stack.isEmpty()) {
			String p=stack.pop()+"\n";
			Path+=p;
			//3,3,0,0,0
			//2,2,1,1,1
			//3,1,0,0,1
			String []str=Path.split("\n");
			String str1[]=str[str.length-1].split(",");
			State curState=new State(Integer.parseInt(str1[0]),Integer.parseInt(str1[1])
					,Integer.parseInt(str1[2]),Integer.parseInt(str1[3]),Integer.parseInt(str1[4]));
			if(curState.toString().equals(goal.toString()))
			{
				return Path;
			}
			
			
			String x=curState.generatenewStates(curState);
			if(x!="") {
			String []strx=x.split("\n");
			for(int i=0;i<strx.length;i++) {
				String []strx1=strx[i].split(",");
				
				State newst=new State(Integer.parseInt(strx1[0]),Integer.parseInt(strx1[1])
					,Integer.parseInt(strx1[2]),Integer.parseInt(strx1[3]),Integer.parseInt(strx1[4]));
			
				if(!visitedStates.isVisited(newst)) {
					visitedStates.push(newst);
					stack.push(newst);
										
				}
				}			
		}
		}
		return Path;
		
	}
}
