package shop.jarviis.api.cloud.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.jarviis.api.cloud.board.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
}
