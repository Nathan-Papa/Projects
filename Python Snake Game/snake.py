import pygame
import time
import random
 
pygame.init()
gameScreen = pygame.display.set_mode((600, 600))
pygame.display.set_caption("Python Snake Game")

carryOn = True
x = 240
y = 285
 
clock = pygame.time.Clock()

while carryOn:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
              carryOn = False
        gameScreen.fill((0, 255, 0))
        x += 5
        snake = pygame.draw.rect(gameScreen, (0, 0, 255), [x, y, 120, 30],0)
        snake.move(200,0)
        pygame.display.flip()
        clock.tick(60)
 
pygame.quit()