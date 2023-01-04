import pygame
import random
import time

pygame.init()
side_length = 500
grid_colors = ["darkolivegreen1", "darkolivegreen3"]
colors = ["blue", "green", "red", "purple", "yellow", "turquoise", "darkslategrey", "lightblue3"]
sq_length = 25
clock = pygame.time.Clock()
mine = pygame.image.load("mine.jpg")
mine = pygame.transform.scale(mine, (25, 25))
font = pygame.font.Font('freesansbold.ttf', 20)
locations = []
for mines in range(60):
        locations.append((random.randint(0, 20) * sq_length, random.randint(0, 20) * sq_length))

gameboard = pygame.display.set_mode((side_length, side_length))
pygame.display.set_caption("Mine Sweeper")

for col in range(20):
    color = col % 2
    for row in range(20):
        tile = pygame.Rect(col*sq_length, row*sq_length, sq_length, sq_length)
        gameboard.fill(grid_colors[color], tile)
        color = (color + 1) % 2

while True: 
    ev = pygame.event.poll()
    if ev.type == pygame.QUIT:
        pygame.quit()

    if ev.type == pygame.MOUSEBUTTONDOWN:
        position = (ev.dict["pos"][0] - (ev.dict["pos"][0] % 25), ev.dict["pos"][1] - (ev.dict["pos"][1] % 25))
        if position in locations:
            for location in range(len(locations)):
                gameboard.blit(mine, locations[location])
            pygame.display.flip()
            time.sleep(3)
            break
        else:
            adj = 0
            for row in range(-1 * sq_length, 2 * sq_length, sq_length):
                for col in range(-1 * sq_length, 2 * sq_length, sq_length):
                    if (position[0] - row, position[1] - col) in locations:
                        adj += 1
            tile = pygame.Rect(position[0], position[1], sq_length, sq_length)
            gameboard.fill("lightgrey", tile)
            text = font.render(str(adj), True, colors[adj-1], "lightgrey")
            gameboard.blit(text, (position[0] + (sq_length / 2), position[1]))


    pygame.display.flip()
    clock.tick(60)


pygame.quit()
